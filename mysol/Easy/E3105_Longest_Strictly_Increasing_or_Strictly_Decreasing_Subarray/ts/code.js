function longestMonotonicSubarray(nums) {
    if (!nums || nums.length === 0)
        return 0;
    let maxLength = 1; // Minimum length of any subarray is 1
    let incLength = 1; // Length of the current increasing subarray
    let decLength = 1; // Length of the current decreasing subarray
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            incLength++;
            decLength = 1; // Reset decreasing subarray length
        }
        else if (nums[i] < nums[i - 1]) {
            decLength++;
            incLength = 1; // Reset increasing subarray length
        }
        else {
            // Reset both lengths when elements are equal
            incLength = 1;
            decLength = 1;
        }
        // Update the maximum length found so far
        maxLength = Math.max(maxLength, Math.max(incLength, decLength));
    }
    return maxLength;
}
;
const input = [1, 4, 3, 3, 2];
const results = longestMonotonicSubarray(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
