function sortBy(arr, fn) {
    return arr.slice().sort(function (a, b) {
        var aValue = fn(a);
        var bValue = fn(b);
        return aValue - bValue;
    });
}
;
var input1 = [5, 4, 1, 2, 3];
var input2 = [{ "x": 1 }, { "x": 0 }, { "x": -1 }];
var fn1 = function (x) { return x; };
var fn2 = function (d) { return d.x; };
var output1 = sortBy(input1, fn1);
var output2 = sortBy(input2, fn2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
