/**
 * @param {number[]} nums
 * @return {number}
 */
var validSubarrays = function(nums) {
    const stack = [];
    let count = 0;

    for (const num of nums) {
        while (stack.length > 0 && stack[stack.length - 1] > num) {
            stack.pop();
        }

        stack.push(num);
        count += stack.length;
    }

    return count;
};

document.getElementById("title").innerText =
    "1063. Number of Valid Subarrays (JS)";

let output = "";

// Example 1
const nums1 = [1, 4, 2, 5, 3];

output += "<b>Input:</b> nums = [" + nums1 + "]<br>";
output += "<b>Output:</b> " + validSubarrays(nums1);
output += "<br><br>";

// Example 2
const nums2 = [3, 2, 1];

output += "<b>Input:</b> nums = [" + nums2 + "]<br>";
output += "<b>Output:</b> " + validSubarrays(nums2);
output += "<br><br>";

// Example 3
const nums3 = [2, 2, 2];

output += "<b>Input:</b> nums = [" + nums3 + "]<br>";
output += "<b>Output:</b> " + validSubarrays(nums3);

document.getElementById("output").innerHTML = output;