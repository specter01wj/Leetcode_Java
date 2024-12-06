function minimumSum(nums) {
    const n = nums.length;
    let minSum = Infinity;
    let hasMountain = false;
    // Iterate through the middle element of the triplet (j)
    for (let j = 1; j < n - 1; j++) {
        let leftMin = Infinity;
        let rightMin = Infinity;
        // Find the smallest valid i (nums[i] < nums[j]) to the left of j
        for (let i = 0; i < j; i++) {
            if (nums[i] < nums[j]) {
                leftMin = Math.min(leftMin, nums[i]);
            }
        }
        // Find the smallest valid k (nums[k] < nums[j]) to the right of j
        for (let k = j + 1; k < n; k++) {
            if (nums[k] < nums[j]) {
                rightMin = Math.min(rightMin, nums[k]);
            }
        }
        // If valid i and k are found, calculate the mountain triplet sum
        if (leftMin !== Infinity && rightMin !== Infinity) {
            hasMountain = true;
            const currentSum = leftMin + nums[j] + rightMin;
            minSum = Math.min(minSum, currentSum);
        }
    }
    // Return the minimum sum if a mountain triplet exists, otherwise -1
    return hasMountain ? minSum : -1;
}
;
const input = [5, 4, 8, 7, 10, 2];
const results = minimumSum(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
