function mostCompetitive(nums: number[], k: number): number[] {
    const stack: number[] = [];

    for (let i = 0; i < nums.length; i++) {
        while (
            stack.length > 0 &&
            stack[stack.length - 1] > nums[i] &&
            stack.length + nums.length - i > k
        ) {
            stack.pop();
        }

        if (stack.length < k) {
            stack.push(nums[i]);
        }
    }

    return stack;
}

(document.getElementById("title") as HTMLElement).innerText =
    "1673. Find the Most Competitive Subsequence (TS)";

let output: string = "";

// Example 1
const nums1: number[] = [3, 5, 2, 6];
const k1: number = 2;

output += "<b>Input:</b> nums = [" + nums1 + "], k = " + k1 + "<br>";
output += "<b>Output:</b> [" + mostCompetitive(nums1, k1) + "]";
output += "<br><br>";

// Example 2
const nums2: number[] = [2, 4, 3, 3, 5, 4, 9, 6];
const k2: number = 4;

output += "<b>Input:</b> nums = [" + nums2 + "], k = " + k2 + "<br>";
output += "<b>Output:</b> [" + mostCompetitive(nums2, k2) + "]";

(document.getElementById("output") as HTMLElement).innerHTML = output;