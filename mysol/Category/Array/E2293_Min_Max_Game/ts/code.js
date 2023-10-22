function minMaxGame(nums) {
    while (nums.length > 1) {
        var n = nums.length;
        var newNums = new Array(Math.floor(n / 2)).fill(0);
        for (var i = 0; i < Math.floor(n / 2); i++) {
            if (i % 2 === 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
            else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        nums = newNums;
    }
    return nums[0];
}
var input = [1, 3, 5, 2, 4, 8, 2, 2];
var output = minMaxGame(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
