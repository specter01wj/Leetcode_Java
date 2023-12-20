function findMaxAverage(nums, k) {
    var sum = 0;
    for (var i = 0; i < k; i++) {
        sum += nums[i];
    }
    var max = sum;
    for (var i = k; i < nums.length; i++) {
        sum = sum - nums[i - k] + nums[i];
        max = Math.max(max, sum);
    }
    return max / k;
}
;
var input1 = [1, 12, -5, -6, 50, 3], k = 4;
var output1 = findMaxAverage(input1, 4);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
