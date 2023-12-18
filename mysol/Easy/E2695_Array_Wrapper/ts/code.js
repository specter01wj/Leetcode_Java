var ArrayWrapper = /** @class */ (function () {
    function ArrayWrapper(nums) {
        this.nums = nums;
    }
    ArrayWrapper.prototype.valueOf = function () {
        return this.nums.reduce(function (acc, num) { return acc + num; }, 0);
    };
    ArrayWrapper.prototype.toString = function () {
        return '[' + this.nums.join(',') + ']';
    };
    return ArrayWrapper;
}());
;
var input1 = '';
var obj1 = new ArrayWrapper([1, 2]);
var obj2 = new ArrayWrapper([3, 4]);
var output1 = obj1 + obj2; // 10
var output2 = String(obj1); // "[1,2]"
var output3 = String(obj2); // "[3,4]"
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
