function lastVisitedIntegers(nums) {
    const seen = []; // Array to track "seen" positive integers
    const ans = []; // Array to store the result
    let consecutiveNegativeCount = 0;
    for (const num of nums) {
        if (num > 0) {
            // If positive, prepend to `seen` and reset the counter
            seen.unshift(num);
            consecutiveNegativeCount = 0;
        }
        else if (num === -1) {
            // Handle consecutive -1s
            consecutiveNegativeCount++;
            if (consecutiveNegativeCount <= seen.length) {
                ans.push(seen[consecutiveNegativeCount - 1]);
            }
            else {
                ans.push(-1);
            }
        }
    }
    return ans;
}
;
const input = [1, 2, -1, -1, -1];
const results = lastVisitedIntegers(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
