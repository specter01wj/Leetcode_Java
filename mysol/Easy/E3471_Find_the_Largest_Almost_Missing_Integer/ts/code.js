function largestInteger(nums, k) {
    const freqMap = new Map();
    const n = nums.length;
    for (let i = 0; i <= n - k; i++) {
        const windowSet = new Set();
        for (let j = i; j < i + k; j++) {
            windowSet.add(nums[j]);
        }
        for (const num of windowSet) {
            freqMap.set(num, (freqMap.get(num) || 0) + 1);
        }
    }
    let max = -1;
    for (const [num, count] of freqMap.entries()) {
        if (count === 1) {
            max = Math.max(max, num);
        }
    }
    return max;
}
;
const input = [3, 9, 2, 1, 7];
const k = 3;
const results = largestInteger(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
