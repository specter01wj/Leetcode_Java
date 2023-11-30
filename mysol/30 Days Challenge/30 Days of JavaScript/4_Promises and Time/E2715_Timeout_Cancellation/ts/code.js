function cancellable(fn, args, t) {
    var timeoutId = null;
    var cancelFn = function () {
        clearTimeout(timeoutId);
    };
    timeoutId = setTimeout(function () {
        fn.apply(void 0, args);
    }, t);
    return cancelFn;
}
;
var result = [];
var fn = function (x) { return x * 5; };
var args = [2], t = 20, cancelT = 50;
var start = performance.now();
var log = function () {
    var argsArr = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        argsArr[_i] = arguments[_i];
    }
    var diff = Math.floor(performance.now() - start);
    result.push({ "time": diff, "returned": fn.apply(void 0, argsArr) });
};
var cancel = cancellable(log, args, t);
var maxT = Math.max(t, cancelT);
setTimeout(function () {
    cancel();
}, cancelT);
setTimeout(function () {
    console.log(result); // [{"time":20,"returned":10}]
    var output1 = result;
    var webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + 'Time - ' + (output1[0].time) + '; Returned - ' + (output1[0].returned);
}, maxT + 15);
