function cancellable(fn, args, t) {
    fn.apply(null, args);
    var intervalId = setInterval(function () {
        fn.apply(null, args);
    }, t);
    return function cancelFn() {
        clearInterval(intervalId);
    };
}
;
var result = [];
var fn = function (x) { return x * 2; };
var args = [4], t = 35, cancelT = 190;
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
    console.log(result);
    var output1 = result;
    var webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + 'Time - ' + (output1[0].time) + '; Returned - ' + (output1[0].returned);
}, maxT + 15);
