function isEmpty(obj) {
    return Object.keys(obj).length === 0;
}
;
var input1 = { "x": 5, "y": 42 }, input2 = {};
var output1 = isEmpty(input1);
var output2 = isEmpty(input2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
