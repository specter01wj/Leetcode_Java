function once(fn) {
    var called = false;
    var result;
    return function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        if (!called) {
            result = fn.apply(void 0, args);
            called = true;
            return result;
        }
        else {
            return undefined;
        }
    };
}
var fn = function (a, b, c) { return (a + b + c); };
var onceFn = once(fn);
var output1 = onceFn(1, 2, 3);
var output2 = onceFn(2, 3, 6);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
