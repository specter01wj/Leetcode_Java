function findXSum(nums, k, x) {
    const n = nums.length;
    const result = [];
    const freq = new Map();
    // Initialize frequency map with first k elements
    for (let i = 0; i < k; i++) {
        freq.set(nums[i], (freq.get(nums[i]) || 0) + 1);
    }
    result.push(computeXSum(freq, x));
    // Slide the window
    for (let i = k; i < n; i++) {
        const outVal = nums[i - k];
        const outCount = freq.get(outVal) - 1;
        if (outCount === 0) {
            freq.delete(outVal);
        }
        else {
            freq.set(outVal, outCount);
        }
        const inVal = nums[i];
        freq.set(inVal, (freq.get(inVal) || 0) + 1);
        result.push(computeXSum(freq, x));
    }
    return result;
}
;
function computeXSum(freqMap, x) {
    const freqList = [];
    // Convert map to list of [value, frequency]
    for (const [val, count] of freqMap.entries()) {
        freqList.push([val, count]);
    }
    // Sort by frequency descending, then value descending
    freqList.sort((a, b) => {
        if (b[1] !== a[1])
            return b[1] - a[1];
        return b[0] - a[0];
    });
    // Pick top x values
    const topX = new Set();
    for (let i = 0; i < Math.min(x, freqList.length); i++) {
        topX.add(freqList[i][0]);
    }
    // Compute sum of top x frequent values
    let sum = 0;
    for (const [val, count] of freqMap.entries()) {
        if (topX.has(val)) {
            sum += val * count;
        }
    }
    return sum;
}
const input = [1, 1, 2, 2, 3, 4, 2, 3];
const k = 6, x = 2;
const results = findXSum(input, k, x);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
