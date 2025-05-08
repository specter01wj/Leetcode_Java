function maxSum(nums) {
    const unique = new Set();
    let sum = 0;
    let maxNegative = -Infinity;
    for (const num of nums) {
        if (num > 0) {
            unique.add(num);
        }
        else {
            maxNegative = Math.max(maxNegative, num);
        }
    }
    for (const val of unique) {
        sum += val;
    }
    return unique.size > 0 ? sum : maxNegative;
}
;
const input = [1, 2, -1, -2, 1, 0, -1];
const results = maxSum(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
