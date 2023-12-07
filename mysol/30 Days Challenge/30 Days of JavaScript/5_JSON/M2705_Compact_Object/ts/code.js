function compactObject(obj) {
    if (Array.isArray(obj)) {
        return obj
            .map(function (item) { return (item && typeof item === 'object' ? compactObject(item) : item); })
            .filter(Boolean);
    }
    var result = {};
    for (var key in obj) {
        if (obj.hasOwnProperty(key)) {
            var value = obj[key];
            if (value && typeof value === 'object') {
                result[key] = compactObject(value);
            }
            else if (value) {
                result[key] = value;
            }
        }
    }
    return result;
}
;
var input1 = [null, 0, false, 1];
var input2 = { "a": null, "b": [false, 1] };
var input3 = [null, 0, 5, [0], [false, 16]];
var output1 = compactObject(input1);
var output2 = compactObject(input2);
var output3 = compactObject(input3);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
