function rob(nums) {
    if (nums.length === 0)
        return 0;
    if (nums.length === 1)
        return nums[0];
    var dp = [nums[0], Math.max(nums[0], nums[1])];
    for (var i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }
    return dp[nums.length - 1];
}
;
var input1 = [2, 7, 9, 3, 1];
var output1 = rob(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
