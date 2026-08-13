function maxSlidingWindow(nums, k) {
    const answer = new Array(nums.length - k + 1).fill(0);
    const deque = [];
    for (let i = 0; i < nums.length; i++) {
        // Remove indices that are outside the current window
        if (deque.length > 0 && deque[0] < i - k + 1) {
            deque.shift();
        }
        // Maintain monotonic decreasing order
        while (deque.length > 0 &&
            nums[deque[deque.length - 1]] < nums[i]) {
            deque.pop();
        }
        // Store the current index
        deque.push(i);
        // Record maximum once the first window is complete
        if (i >= k - 1) {
            answer[i - k + 1] = nums[deque[0]];
        }
    }
    return answer;
}
document.getElementById("title").innerText =
    "239. Sliding Window Maximum (TS)";
let output = "";
// Example 1
const input1 = [1, 3, -1, -3, 5, 3, 6, 7];
const k1 = 3;
output += "<b>Example 1 Input:</b><br>";
output += "nums = [" + input1.join(", ") + "], k = " + k1;
output += "<br><br>";
output += "<b>Example 1 Output:</b><br>";
output += "[" + maxSlidingWindow(input1, k1).join(", ") + "]";
output += "<br><br>";
// Example 2
const input2 = [1];
const k2 = 1;
output += "<b>Example 2 Input:</b><br>";
output += "nums = [" + input2.join(", ") + "], k = " + k2;
output += "<br><br>";
output += "<b>Example 2 Output:</b><br>";
output += "[" + maxSlidingWindow(input2, k2).join(", ") + "]";
document.getElementById("output").innerHTML = output;
