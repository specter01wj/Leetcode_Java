function memoize(fn) {
    var cache = {};
    return function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        var key = JSON.stringify(args);
        if (key in cache) {
            return cache[key];
        }
        else {
            var result = fn.apply(this, args);
            cache[key] = result;
            return result;
        }
    };
}
var callCount = 0;
var memoizedFn = memoize(function (a, b) {
    callCount += 1;
    return a + b;
});
var output1 = memoizedFn(2, 3);
var output2 = memoizedFn(2, 3);
var output3 = callCount;
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + output3.toString();
