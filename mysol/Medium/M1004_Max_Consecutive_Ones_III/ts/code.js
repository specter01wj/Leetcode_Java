function longestOnes(nums, k) {
    var left = 0, right = 0;
    var maxOnes = 0;
    var zeroCount = 0;
    while (right < nums.length) {
        // If the current element is 0, increment the zero count
        if (nums[right] === 0) {
            zeroCount++;
        }
        // If zero count exceeds k, shrink the window from the left
        while (zeroCount > k) {
            if (nums[left] === 0) {
                zeroCount--;
            }
            left++;
        }
        // Update the maximum size of the window
        maxOnes = Math.max(maxOnes, right - left + 1);
        right++;
    }
    return maxOnes;
}
;
var input1 = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], k = 2;
var output1 = longestOnes(input1, k);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
