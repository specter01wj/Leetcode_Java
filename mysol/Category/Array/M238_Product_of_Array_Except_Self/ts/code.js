function productExceptSelf(nums) {
    var length = nums.length;
    var leftProducts = new Array(length);
    var rightProducts = new Array(length);
    var answer = new Array(length);
    leftProducts[0] = 1;
    for (var i = 1; i < length; i++) {
        leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
    }
    rightProducts[length - 1] = 1;
    for (var i = length - 2; i >= 0; i--) {
        rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
    }
    for (var i = 0; i < length; i++) {
        answer[i] = leftProducts[i] * rightProducts[i];
    }
    return answer;
}
;
var input1 = [1, 2, 3, 4];
var output1 = productExceptSelf(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
