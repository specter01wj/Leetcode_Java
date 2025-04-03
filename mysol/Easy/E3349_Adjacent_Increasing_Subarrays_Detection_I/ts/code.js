function hasIncreasingSubarrays(nums, k) {
    const n = nums.length;
    if (n < 2 * k)
        return false;
    for (let i = 0; i <= n - 2 * k; i++) {
        if (isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k)) {
            return true;
        }
    }
    return false;
}
;
function isIncreasing(nums, start, k) {
    for (let i = start + 1; i < start + k; i++) {
        if (nums[i] <= nums[i - 1]) {
            return false;
        }
    }
    return true;
}
const input = [2, 5, 7, 8, 9, 2, 3, 4, 3, 1];
const k = 3;
const results = hasIncreasingSubarrays(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
