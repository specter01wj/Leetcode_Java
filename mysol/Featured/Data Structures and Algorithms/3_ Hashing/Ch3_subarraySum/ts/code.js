function subarraySum(nums, k) {
    const prefixSumCount = new Map();
    prefixSumCount.set(0, 1);
    let prefixSum = 0;
    let count = 0;
    for (const num of nums) {
        prefixSum += num;
        if (prefixSumCount.has(prefixSum - k)) {
            count += prefixSumCount.get(prefixSum - k);
        }
        prefixSumCount.set(prefixSum, (prefixSumCount.get(prefixSum) || 0) + 1);
    }
    return count;
}
;
const input = [1, 2, 3];
const k = 3;
const results = subarraySum(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
