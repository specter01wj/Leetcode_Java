type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function join(arr1: JSONValue[], arr2: JSONValue[]): JSONValue[] {
	const mergedObjects = new Map<number, { [key: string]: JSONValue }>();

    const mergeObjects = (obj1: { [key: string]: JSONValue }, obj2: { [key: string]: JSONValue }) => {
        for (let key in obj2) {
            obj1[key] = obj2[key];
        }
        return obj1;
    };

    [arr1, arr2].forEach(array => {
        array.forEach(item => {
            if (typeof item === 'object' && item !== null && 'id' in item) {
                const obj = item as { [key: string]: JSONValue };
                const id = obj.id as number;

                if (mergedObjects.has(id)) {
                    mergedObjects.set(id, mergeObjects(mergedObjects.get(id)!, obj));
                } else {
                    mergedObjects.set(id, { ...obj });
                }
            }
        });
    });

    return Array.from(mergedObjects.values()).sort((a, b) => (a.id as number) - (b.id as number));
};


let input1 = [{"id": 1, "x": 1}, {"id": 2, "x": 9}], arr1 = [{"id": 3, "x": 5}];
let input2 = [{"id": 1, "x": 2, "y": 3}, {"id": 2, "x": 3, "y": 6}], arr2 = [{"id": 2, "x": 10, "y": 20}, {"id": 3, "x": 0, "y": 0}];
let input3 = [{"id": 1, "b": {"b": 94},"v": [4, 3], "y": 48}], arr3 = [{"id": 1, "b": {"c": 84}, "v": [1, 3]}];

let output1 = join(input1, arr1);
let output2 = join(input2, arr2);
let output3 = join(input3, arr3);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);



