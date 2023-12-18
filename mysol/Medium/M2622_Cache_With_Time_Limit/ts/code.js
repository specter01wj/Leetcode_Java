var TimeLimitedCache = /** @class */ (function () {
    function TimeLimitedCache() {
        this.cache = {};
        this.expiryTimes = {};
    }
    TimeLimitedCache.prototype.set = function (key, value, duration) {
        var now = new Date().getTime();
        var alreadyExistsAndUnexpired = this.cache.hasOwnProperty(key) && now < this.expiryTimes[key];
        this.cache[key] = value;
        this.expiryTimes[key] = now + duration;
        return alreadyExistsAndUnexpired;
    };
    TimeLimitedCache.prototype.get = function (key) {
        var now = new Date().getTime();
        if (this.cache.hasOwnProperty(key) && now < this.expiryTimes[key]) {
            return this.cache[key];
        }
        return -1;
    };
    TimeLimitedCache.prototype.count = function () {
        var _this = this;
        var now = new Date().getTime();
        return Object.keys(this.expiryTimes).reduce(function (count, key) {
            var numericKey = parseInt(key);
            if (now < _this.expiryTimes[numericKey]) {
                count++;
            }
            return count;
        }, 0);
    };
    return TimeLimitedCache;
}());
var timeLimitedCache = new TimeLimitedCache();
var output1 = timeLimitedCache.set(1, 42, 1000); // false
var output2 = timeLimitedCache.get(1); // 42
var output3 = timeLimitedCache.count(); // 1
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + (output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + (output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + (output3);
