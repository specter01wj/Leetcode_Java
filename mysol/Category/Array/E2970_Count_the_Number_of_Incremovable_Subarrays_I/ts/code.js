function incremovableSubarrayCount(nums) {
    const n = nums.length;
    let count = 0;
    // Helper function to check if a subarray is incremovable
    const isIncremovable = (start, end) => {
        let prev = -Infinity;
        for (let i = 0; i < n; i++) {
            if (i < start || i > end) { // Skip the subarray [start, end]
                if (nums[i] <= prev) {
                    return false; // Not strictly increasing
                }
                prev = nums[i];
            }
        }
        return true;
    };
    // Iterate over all possible subarray start and end indices
    for (let start = 0; start < n; start++) {
        for (let end = start; end < n; end++) {
            if (isIncremovable(start, end)) {
                count++;
            }
        }
    }
    return count;
}
;
const input = [6, 5, 7, 8];
const results = incremovableSubarrayCount(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
