function increasingTriplet(nums) {
    if (nums === null || nums.length < 3) {
        return false;
    }
    var first = Number.MAX_SAFE_INTEGER;
    var second = Number.MAX_SAFE_INTEGER;
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        if (num <= first) {
            first = num;
        }
        else if (num <= second) {
            second = num;
        }
        else {
            return true;
        }
    }
    return false;
}
;
var input1 = [2, 1, 5, 0, 4, 6];
var output1 = increasingTriplet(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
