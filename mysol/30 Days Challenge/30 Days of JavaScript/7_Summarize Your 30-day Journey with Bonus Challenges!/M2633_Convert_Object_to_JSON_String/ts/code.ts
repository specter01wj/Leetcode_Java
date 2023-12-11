type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function jsonStringify(object: JSONValue): string {
	// Handle null
    if (object === null) {
        return "null";
    }

    // Handle strings
    if (typeof object === 'string') {
        return `"${object}"`;
    }

    // Handle numbers
    if (typeof object === 'number') {
        return object.toString();
    }

    // Handle booleans
    if (typeof object === 'boolean') {
        return object.toString();
    }

    // Handle arrays
    if (Array.isArray(object)) {
        const result = object.map(item => jsonStringify(item)).join(",");
        return `[${result}]`;
    }

    // Handle objects
    if (typeof object === 'object') {
        const keys = Object.keys(object);
        const result = keys.map(key => {
            const value = (object as { [key: string]: JSONValue })[key];
            return `"${key}":${jsonStringify(value)}`;
        }).join(",");
        return `{${result}}`;
    }

    // Unsupported types (e.g., functions, undefined)
    throw new Error('Unsupported type');
};

let input1 = {"y":1,"x":2};
let input2 = {"a":"str","b":-12,"c":true,"d":null};
let input3 = {"key":{"a":1,"b":[{},null,"Hello"]}};

let output1 = jsonStringify(input1);
let output2 = jsonStringify(input2);
let output3 = jsonStringify(input3);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);


