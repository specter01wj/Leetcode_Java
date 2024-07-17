var TwoSum = /** @class */ (function () {
    function TwoSum() {
        this.numCounts = new Map();
    }
    TwoSum.prototype.add = function (number) {
        if (this.numCounts.has(number)) {
            this.numCounts.set(number, this.numCounts.get(number) + 1);
        }
        else {
            this.numCounts.set(number, 1);
        }
    };
    TwoSum.prototype.find = function (value) {
        for (var _i = 0, _a = this.numCounts; _i < _a.length; _i++) {
            var _b = _a[_i], key = _b[0], count = _b[1];
            var complement = value - key;
            if (complement === key) {
                if (count > 1) {
                    return true;
                }
            }
            else {
                if (this.numCounts.has(complement)) {
                    return true;
                }
            }
        }
        return false;
    };
    TwoSum.prototype.toString = function () {
        var obj = {};
        for (var _i = 0, _a = this.numCounts; _i < _a.length; _i++) {
            var _b = _a[_i], key = _b[0], value = _b[1];
            obj[key] = value;
        }
        return JSON.stringify(obj);
    };
    return TwoSum;
}());
var obj = new TwoSum();
obj.add(1); // [] --> [1]
obj.add(3); // [1] --> [1, 3]
obj.add(5); // [1, 3] --> [1, 3, 5]
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + obj.toString();
