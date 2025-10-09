function findMaxLength(nums) {
    const sumToIndex = new Map();
    sumToIndex.set(0, -1);
    let maxLen = 0;
    let sum = 0;
    for (let i = 0; i < nums.length; i++) {
        sum += (nums[i] === 0) ? -1 : 1;
        if (sumToIndex.has(sum)) {
            maxLen = Math.max(maxLen, i - sumToIndex.get(sum));
        }
        else {
            sumToIndex.set(sum, i);
        }
    }
    return maxLen;
}
;
const input = [0, 1, 1, 1, 1, 1, 0, 0, 0];
const results = findMaxLength(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
