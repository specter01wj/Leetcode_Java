function throttle(fn, t) {
    var lastCall = 0;
    var timeoutId = null;
    var lastArgs = null;
    return function () {
        var _this = this;
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        var now = Date.now();
        // If this is the first call or the last call was t or more milliseconds ago
        if (lastCall === 0 || (now - lastCall >= t)) {
            // Call the function immediately and update lastCall
            lastCall = now;
            fn.apply(this, args);
        }
        else {
            // Save the latest arguments
            lastArgs = args;
            // Clear the existing timeout, if any
            if (timeoutId) {
                clearTimeout(timeoutId);
            }
            // Set a new timeout to call the function after the remaining time in the t milliseconds period
            timeoutId = setTimeout(function () {
                // Update lastCall to the current time
                lastCall = Date.now();
                fn.apply(_this, lastArgs);
                lastArgs = null;
                timeoutId = null;
            }, lastCall + t - now);
        }
    };
}
;
var input = '';
var throttled = throttle(function (item) {
    var output1 = item;
    var webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + output1.toString();
}, 1000);
throttled("log"); // logged immediately.
throttled("log1000"); // logged at t=100ms.
