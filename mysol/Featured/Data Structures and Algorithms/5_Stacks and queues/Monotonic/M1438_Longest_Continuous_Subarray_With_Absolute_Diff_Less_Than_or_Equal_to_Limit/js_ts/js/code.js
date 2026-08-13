var longestSubarray = function(nums, limit) {

    const increasing = [];
    const decreasing = [];

    let left = 0;
    let answer = 0;

    for (let right = 0; right < nums.length; right++) {

        // Maintain increasing deque
        while (
            increasing.length > 0 &&
            increasing[increasing.length - 1] > nums[right]
        ) {
            increasing.pop();
        }

        // Maintain decreasing deque
        while (
            decreasing.length > 0 &&
            decreasing[decreasing.length - 1] < nums[right]
        ) {
            decreasing.pop();
        }

        increasing.push(nums[right]);
        decreasing.push(nums[right]);

        // Shrink window until max - min <= limit
        while (decreasing[0] - increasing[0] > limit) {

            if (nums[left] === decreasing[0]) {
                decreasing.shift();
            }

            if (nums[left] === increasing[0]) {
                increasing.shift();
            }

            left++;
        }

        answer = Math.max(answer, right - left + 1);
    }

    return answer;
};

document.getElementById("title").innerText =
    "1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (JS)";

let output = "";

// Example 1
const input1 = [8, 2, 4, 7];
const limit1 = 4;

output += "<b>Example 1 Input:</b><br>";
output += "nums = [" + input1.join(", ") + "], limit = " + limit1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += longestSubarray(input1, limit1);
output += "<br><br>";

// Example 2
const input2 = [10, 1, 2, 4, 7, 2];
const limit2 = 5;

output += "<b>Example 2 Input:</b><br>";
output += "nums = [" + input2.join(", ") + "], limit = " + limit2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += longestSubarray(input2, limit2);
output += "<br><br>";

// Example 3
const input3 = [4, 2, 2, 2, 4, 4, 2, 2];
const limit3 = 0;

output += "<b>Example 3 Input:</b><br>";
output += "nums = [" + input3.join(", ") + "], limit = " + limit3;
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += longestSubarray(input3, limit3);

document.getElementById("output").innerHTML = output;