/**
 * @param {number[]} nums
 * @return {number}
 */
var subArrayRanges = function(nums) {
    const n = nums.length;
    let minSum = 0;
    let maxSum = 0;

    const stack = [];

    // Sum of minimums
    for (let i = 0; i <= n; i++) {
        while (
            stack.length > 0 &&
            (i === n || nums[stack[stack.length - 1]] > nums[i])
        ) {
            const index = stack.pop();
            const left =
                stack.length === 0 ? index + 1 : index - stack[stack.length - 1];
            const right = i - index;

            minSum += nums[index] * left * right;
        }

        stack.push(i);
    }

    stack.length = 0;

    // Sum of maximums
    for (let i = 0; i <= n; i++) {
        while (
            stack.length > 0 &&
            (i === n || nums[stack[stack.length - 1]] < nums[i])
        ) {
            const index = stack.pop();
            const left =
                stack.length === 0 ? index + 1 : index - stack[stack.length - 1];
            const right = i - index;

            maxSum += nums[index] * left * right;
        }

        stack.push(i);
    }

    return maxSum - minSum;
};

document.getElementById("title").innerText =
    "2104. Sum of Subarray Ranges (JS)";

let output = "";

// Example 1
const nums1 = [1, 2, 3];

output += "<b>Input:</b> nums = [" + nums1 + "]<br>";
output += "<b>Output:</b> " + subArrayRanges(nums1);
output += "<br><br>";

// Example 2
const nums2 = [1, 3, 3];

output += "<b>Input:</b> nums = [" + nums2 + "]<br>";
output += "<b>Output:</b> " + subArrayRanges(nums2);
output += "<br><br>";

// Example 3
const nums3 = [4, -2, -3, 4, 1];

output += "<b>Input:</b> nums = [" + nums3 + "]<br>";
output += "<b>Output:</b> " + subArrayRanges(nums3);

document.getElementById("output").innerHTML = output;