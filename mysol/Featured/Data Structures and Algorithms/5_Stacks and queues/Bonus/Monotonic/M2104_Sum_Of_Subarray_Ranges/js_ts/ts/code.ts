function subArrayRanges(nums: number[]): number {
    const n: number = nums.length;
    let minSum: number = 0;
    let maxSum: number = 0;

    const stack: number[] = [];

    // Sum of minimums
    for (let i = 0; i <= n; i++) {
        while (
            stack.length > 0 &&
            (i === n || nums[stack[stack.length - 1]] > nums[i])
        ) {
            const index: number = stack.pop()!;
            const left: number =
                stack.length === 0 ? index + 1 : index - stack[stack.length - 1];
            const right: number = i - index;

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
            const index: number = stack.pop()!;
            const left: number =
                stack.length === 0 ? index + 1 : index - stack[stack.length - 1];
            const right: number = i - index;

            maxSum += nums[index] * left * right;
        }

        stack.push(i);
    }

    return maxSum - minSum;
}

(document.getElementById("title") as HTMLElement).innerText =
    "2104. Sum of Subarray Ranges (TS)";

let output: string = "";

// Example 1
const nums1: number[] = [1, 2, 3];

output += "<b>Input:</b> nums = [" + nums1 + "]<br>";
output += "<b>Output:</b> " + subArrayRanges(nums1);
output += "<br><br>";

// Example 2
const nums2: number[] = [1, 3, 3];

output += "<b>Input:</b> nums = [" + nums2 + "]<br>";
output += "<b>Output:</b> " + subArrayRanges(nums2);
output += "<br><br>";

// Example 3
const nums3: number[] = [4, -2, -3, 4, 1];

output += "<b>Input:</b> nums = [" + nums3 + "]<br>";
output += "<b>Output:</b> " + subArrayRanges(nums3);

(document.getElementById("output") as HTMLElement).innerHTML = output;