function sumOfSquares(nums) {
    const n = nums.length;
    let sum = 0;
    // Iterate through each index and check if it's special
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) { // Check if i divides n
            sum += nums[i - 1] * nums[i - 1]; // Square the element at index i-1 and add to sum
        }
    }
    return sum;
}
;
const input = [2, 7, 1, 19, 18, 3];
const results = sumOfSquares(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
