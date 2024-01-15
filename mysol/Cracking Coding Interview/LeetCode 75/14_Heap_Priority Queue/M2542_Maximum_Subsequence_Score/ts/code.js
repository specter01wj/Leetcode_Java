function maxScore(nums1, nums2, k) {
    var result = 0;
    var totalSum = 0;
    var heap = new MinPriorityQueue();
    var merged = nums1.map(function (nums1Val, i) { return [nums2[i], nums1Val]; });
    merged.sort(function (a, b) { return b[0] - a[0]; });
    for (var _i = 0, merged_1 = merged; _i < merged_1.length; _i++) {
        var _a = merged_1[_i], maxOf2 = _a[0], num1Val = _a[1];
        if (heap.size === k) {
            totalSum -= heap.dequeue();
        }
        totalSum += num1Val;
        heap.enqueue(num1Val);
        if (heap.size === k) {
            result = Math.max(result, totalSum * maxOf2);
        }
    }
    return result;
}
var MinPriorityQueue = /** @class */ (function () {
    function MinPriorityQueue(comparator) {
        if (comparator === void 0) { comparator = function (a, b) { return a - b; }; }
        this.heap = [];
        this.comparator = comparator;
    }
    Object.defineProperty(MinPriorityQueue.prototype, "size", {
        get: function () {
            return this.heap.length;
        },
        enumerable: false,
        configurable: true
    });
    MinPriorityQueue.prototype.enqueue = function (value) {
        this.heap.push(value);
        this.heap.sort(this.comparator);
    };
    MinPriorityQueue.prototype.dequeue = function () {
        return this.heap.shift();
    };
    MinPriorityQueue.prototype.peek = function () {
        return this.heap[0];
    };
    return MinPriorityQueue;
}());
var input1 = [1, 3, 3, 2], input2 = [2, 1, 3, 4];
var k = 3;
var output1 = maxScore(input1, input2, k);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
