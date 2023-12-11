function jsonStringify(object) {
    // Handle null
    if (object === null) {
        return "null";
    }
    // Handle strings
    if (typeof object === 'string') {
        return "\"".concat(object, "\"");
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
        var result = object.map(function (item) { return jsonStringify(item); }).join(",");
        return "[".concat(result, "]");
    }
    // Handle objects
    if (typeof object === 'object') {
        var keys = Object.keys(object);
        var result = keys.map(function (key) {
            var value = object[key];
            return "\"".concat(key, "\":").concat(jsonStringify(value));
        }).join(",");
        return "{".concat(result, "}");
    }
    // Unsupported types (e.g., functions, undefined)
    throw new Error('Unsupported type');
}
;
var input1 = { "y": 1, "x": 2 };
var input2 = { "a": "str", "b": -12, "c": true, "d": null };
var input3 = { "key": { "a": 1, "b": [{}, null, "Hello"] } };
var output1 = jsonStringify(input1);
var output2 = jsonStringify(input2);
var output3 = jsonStringify(input3);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
