function areDeeplyEqual(o1, o2) {
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
        for (var i = 0; i < o1.length; i++) {
            if (!areDeeplyEqual(o1[i], o2[i])) {
                return false;
            }
        }
        return true;
    }
    // Handle objects
    var keys1 = Object.keys(o1);
    var keys2 = Object.keys(o2);
    if (keys1.length !== keys2.length) {
        return false;
    }
    for (var _i = 0, keys1_1 = keys1; _i < keys1_1.length; _i++) {
        var key = keys1_1[_i];
        if (!keys2.includes(key) || !areDeeplyEqual(o1[key], o2[key])) {
            return false;
        }
    }
    return true;
}
;
var input1 = { "x": 1, "y": 2 }, input2 = { "x": 1, "y": 2 };
var input3 = { "y": 2, "x": 1 }, input4 = { "x": 1, "y": 2 };
var input5 = { "x": null, "L": [1, 2, 3] }, input6 = { "x": null, "L": ["1", "2", "3"] };
var tt1 = areDeeplyEqual(input1, input2);
var tt2 = areDeeplyEqual(input3, input4);
var tt3 = areDeeplyEqual(input5, input6);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
