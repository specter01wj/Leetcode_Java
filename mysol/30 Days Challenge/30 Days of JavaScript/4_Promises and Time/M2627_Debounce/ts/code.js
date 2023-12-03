function debounce(fn, t) {
    var timeoutID;
    return function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        clearTimeout(timeoutID);
        timeoutID = setTimeout(function () {
            fn.apply(void 0, args);
        }, t);
    };
}
;
var output = '';
var log = debounce(function (item) {
    output = item;
    var webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + (output);
}, 100);
log('Hello1'); // cancelled
log('Hello2'); // cancelled
output = log('Hello3'); // Logged at t=100ms
