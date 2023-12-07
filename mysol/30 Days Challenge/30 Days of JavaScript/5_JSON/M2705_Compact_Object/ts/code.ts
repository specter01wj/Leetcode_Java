type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function compactObject(obj: Obj): Obj {
	  if (Array.isArray(obj)) {
        return obj
            .map(item => (item && typeof item === 'object' ? compactObject(item) : item))
            .filter(Boolean) as Array<JSONValue>;
    }

    let result: Record<string, JSONValue> = {};
    for (const key in obj) {
        if (obj.hasOwnProperty(key)) {
            const value = obj[key];
            if (value && typeof value === 'object') {
                result[key] = compactObject(value as Obj);
            } else if (value) {
                result[key] = value;
            }
        }
    }

    return result;
};


let input1 = [null, 0, false, 1];
let input2 = {"a": null, "b": [false, 1]};
let input3 = [null, 0, 5, [0], [false, 16]];
let output1 = compactObject(input1);
let output2 = compactObject(input2);
let output3 = compactObject(input3);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);



