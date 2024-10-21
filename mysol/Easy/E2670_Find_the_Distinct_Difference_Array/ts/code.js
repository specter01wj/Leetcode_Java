function distinctDifferenceArray(nums) {
    const n = nums.length;
    const result = new Array(n);
    // Sets to keep track of distinct elements in prefix and suffix
    const prefixSet = new Set();
    const suffixSet = new Set();
    // Array to store the distinct count in the suffix
    const suffixDistinctCount = new Array(n);
    // Calculate distinct counts in the suffix for each index
    for (let i = n - 1; i >= 0; i--) {
        suffixSet.add(nums[i]);
        suffixDistinctCount[i] = suffixSet.size;
    }
    // Iterate through each index to calculate result
    for (let i = 0; i < n; i++) {
        prefixSet.add(nums[i]);
        // Distinct elements in the prefix: prefixSet.size
        // Distinct elements in the suffix: suffixDistinctCount[i+1] (or 0 if no suffix)
        const suffixCount = (i + 1 < n) ? suffixDistinctCount[i + 1] : 0;
        result[i] = prefixSet.size - suffixCount;
    }
    return result;
}
;
const input = [1, 2, 3, 4, 5];
const results = distinctDifferenceArray(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
