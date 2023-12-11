type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function areDeeplyEqual(o1: JSONValue, o2: JSONValue): boolean {
	// Check for null values
    if (o1 === null || o2 === null) {
        return o1 === o2;
    }

    // Check if both values are of the same type
    if (typeof o1 !== typeof o2) {
        return false;
    }

    // Handle primitive types
    if (typeof o1 !== 'object' || o1 === null || o2 === null) {
        return o1 === o2;
    }

    // Differentiate between arrays and objects
    if (Array.isArray(o1) !== Array.isArray(o2)) {
        return false;
    }

    // Handle arrays
    if (Array.isArray(o1) && Array.isArray(o2)) {
        if (o1.length !== o2.length) {
            return false;
        }
        for (let i = 0; i < o1.length; i++) {
            if (!areDeeplyEqual(o1[i], o2[i])) {
                return false;
            }
        }
        return true;
    }

    // Handle objects
    const keys1 = Object.keys(o1 as object);
    const keys2 = Object.keys(o2 as object);

    if (keys1.length !== keys2.length) {
        return false;
    }

    for (let key of keys1) {
        if (!keys2.includes(key) || !areDeeplyEqual((o1 as { [key: string]: JSONValue })[key], (o2 as { [key: string]: JSONValue })[key])) {
            return false;
        }
    }

    return true;
};

let input1 = {"x":1,"y":2}, input2 = {"x":1,"y":2};
let input3 = {"y":2,"x":1}, input4 = {"x":1,"y":2};
let input5 = {"x":null,"L":[1,2,3]}, input6 = {"x":null,"L":["1","2","3"]};

let output1 = areDeeplyEqual(input1, input2);
let output2 = areDeeplyEqual(input3, input4);
let output3 = areDeeplyEqual(input5, input6);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);


