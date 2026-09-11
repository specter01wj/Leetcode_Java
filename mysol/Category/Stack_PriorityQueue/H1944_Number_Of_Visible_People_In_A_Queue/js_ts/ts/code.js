function canSeePersonsCount(heights) {
    const answer = new Array(heights.length).fill(0);
    const stack = [];
    for (let i = heights.length - 1; i >= 0; i--) {
        while (stack.length > 0 &&
            heights[i] > stack[stack.length - 1]) {
            stack.pop();
            answer[i]++;
        }
        if (stack.length > 0) {
            answer[i]++;
        }
        stack.push(heights[i]);
    }
    return answer;
}
document.getElementById("title").innerText =
    "1944. Number of Visible People in a Queue (TS)";
let output = "";
// Example 1
const heights1 = [10, 6, 8, 5, 11, 9];
output += "<b>Input:</b> heights = [" + heights1 + "]<br>";
output += "<b>Output:</b> [" + canSeePersonsCount(heights1) + "]";
output += "<br><br>";
// Example 2
const heights2 = [5, 1, 2, 3, 10];
output += "<b>Input:</b> heights = [" + heights2 + "]<br>";
output += "<b>Output:</b> [" + canSeePersonsCount(heights2) + "]";
document.getElementById("output").innerHTML = output;
