function maximizeSum(nums, k) {
    // Find the maximum element in nums
    let maxNum = Math.max(...nums);
    // Initialize the sum
    let sum = 0;
    // Perform k operations to maximize the sum
    for (let i = 0; i < k; i++) {
        sum += maxNum; // Add the current largest number to the sum
        maxNum++; // Increment the number by 1 for the next step
    }
    return sum;
}
;
const input = [1, 2, 3, 4, 5], k = 3;
const results = maximizeSum(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
