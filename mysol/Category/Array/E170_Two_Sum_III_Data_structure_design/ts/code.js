function findSubarrays(nums) {
    var seenSums = new Set();
    for (var i = 0; i < nums.length - 1; i++) {
        var sum = nums[i] + nums[i + 1];
        if (seenSums.has(sum)) {
            return true;
        }
        seenSums.add(sum);
    }
    return false;
}
var nums = [4, 2, 4];
var output = findSubarrays(nums);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
