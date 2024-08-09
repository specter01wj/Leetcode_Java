function twoSumLessThanK(nums, k) {
    // Sort the array in ascending order
    nums.sort((a, b) => a - b);
    let left = 0;
    let right = nums.length - 1;
    let maxSum = -1;
    // Two-pointer approach
    while (left < right) {
        const sum = nums[left] + nums[right];
        if (sum < k) {
            maxSum = Math.max(maxSum, sum); // Update maxSum if sum is less than k
            left++; // Move left pointer to the right
        }
        else {
            right--; // Move right pointer to the left
        }
    }
    return maxSum; // Return the maximum sum found or -1 if none found
}
;
const input = [34, 23, 1, 24, 75, 33, 54, 8];
const k = 60;
const results = twoSumLessThanK(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
