function maxSubarrayLength(nums, k) {
    const freq = new Map();
    let left = 0, maxLen = 0;
    for (let right = 0; right < nums.length; right++) {
        freq.set(nums[right], (freq.get(nums[right]) || 0) + 1);
        while ((freq.get(nums[right]) ?? 0) > k) {
            freq.set(nums[left], (freq.get(nums[left]) ?? 0) - 1);
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
;
const input = [1, 2, 3, 1, 2, 3, 1, 2];
const k = 2;
const results = maxSubarrayLength(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
