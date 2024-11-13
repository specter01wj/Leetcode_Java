function isGood(nums) {
    const n = nums.length - 1; // Expected maximum element n
    const count = new Array(n + 1).fill(0);
    // Count the occurrences of each number
    for (const num of nums) {
        if (num > n) {
            return false; // Any number greater than n makes it invalid
        }
        count[num]++;
    }
    // Check that each number from 1 to n-1 appears exactly once
    for (let i = 1; i < n; i++) {
        if (count[i] !== 1) {
            return false;
        }
    }
    // Check that n appears exactly twice
    return count[n] === 2;
}
;
const input = [1, 3, 3, 2];
const results = isGood(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
