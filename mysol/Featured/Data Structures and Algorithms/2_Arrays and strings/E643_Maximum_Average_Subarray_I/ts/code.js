function findMaxAverage(nums, k) {
    let curr = 0;
    for (let i = 0; i < k; i++) {
        curr += nums[i];
    }
    let maxSum = curr;
    for (let i = k; i < nums.length; i++) {
        curr += nums[i] - nums[i - k];
        maxSum = Math.max(maxSum, curr);
    }
    return maxSum / k;
}
;
const input = [1, 12, -5, -6, 50, 3];
const k = 4;
const results = findMaxAverage(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
