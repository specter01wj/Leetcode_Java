var flat = function (arr, n) {
    if (n === 0) {
        return arr;
    }
    var result = [];
    arr.forEach(function (item) {
        if (typeof item === 'number') {
            result.push(item);
        }
        else {
            result.push.apply(result, flat(item, n - 1));
        }
    });
    return result;
};
var input1 = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]];
var n1 = 0, n2 = 1, n3 = 2;
var output1 = flat(input1, n1);
var output2 = flat(input1, n2);
var output3 = flat(input1, n3);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
