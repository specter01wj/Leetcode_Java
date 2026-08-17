function nextGreaterElement(nums1, nums2) {
    const nextGreater = new Map();
    const stack = [];
    for (const num of nums2) {
        // Current number is the next greater element
        while (stack.length > 0 && stack[stack.length - 1] < num) {
            nextGreater.set(stack.pop(), num);
        }
        stack.push(num);
    }
    // Remaining numbers have no next greater element
    while (stack.length > 0) {
        nextGreater.set(stack.pop(), -1);
    }
    const answer = [];
    for (let i = 0; i < nums1.length; i++) {
        answer.push(nextGreater.get(nums1[i]));
    }
    return answer;
}
document.getElementById("title").innerText =
    "496. Next Greater Element I (TS)";
let output = "";
// Example 1
const nums1_1 = [4, 1, 2];
const nums2_1 = [1, 3, 4, 2];
output += "<b>Example 1 Input:</b><br>";
output += "nums1 = [" + nums1_1.join(", ") + "]<br>";
output += "nums2 = [" + nums2_1.join(", ") + "]";
output += "<br><br>";
output += "<b>Example 1 Output:</b><br>";
output += "[" + nextGreaterElement(nums1_1, nums2_1).join(", ") + "]";
output += "<br><br>";
// Example 2
const nums1_2 = [2, 4];
const nums2_2 = [1, 2, 3, 4];
output += "<b>Example 2 Input:</b><br>";
output += "nums1 = [" + nums1_2.join(", ") + "]<br>";
output += "nums2 = [" + nums2_2.join(", ") + "]";
output += "<br><br>";
output += "<b>Example 2 Output:</b><br>";
output += "[" + nextGreaterElement(nums1_2, nums2_2).join(", ") + "]";
document.getElementById("output").innerHTML = output;
