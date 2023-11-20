function arithmeticTriplets(nums, diff) {
    var cnt = 0;
    var numberSet = new Set();
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        if (numberSet.has(num - diff) && numberSet.has(num - diff * 2)) {
            ++cnt;
        }
        numberSet.add(num);
    }
    return cnt;
}
var input = [0, 1, 4, 6, 7, 10], diff = 3;
var output = arithmeticTriplets(input, diff);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
