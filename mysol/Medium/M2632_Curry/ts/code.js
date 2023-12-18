function curry(fn) {
    return function curried() {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        if (args.length >= fn.length) {
            return fn.apply(void 0, args);
        }
        else {
            return function () {
                var moreArgs = [];
                for (var _i = 0; _i < arguments.length; _i++) {
                    moreArgs[_i] = arguments[_i];
                }
                return curried.apply(void 0, args.concat(moreArgs));
            };
        }
    };
}
;
var input1 = [[1], [2], [3]];
var fn = function sum(a, b, c) { return a + b + c; };
var csum1 = curry(fn);
var csum2 = curry(fn);
var csum3 = curry(fn);
var output1 = csum1(1)(2)(3);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var output2 = csum2(1, 2)(3);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var output3 = csum3()()(1, 2, 3);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
