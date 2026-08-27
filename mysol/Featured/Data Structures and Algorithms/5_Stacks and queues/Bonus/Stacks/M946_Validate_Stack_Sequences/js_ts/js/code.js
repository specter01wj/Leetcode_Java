/**
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
var validateStackSequences = function(pushed, popped) {
    const stack = [];
    let j = 0;

    for (const num of pushed) {
        stack.push(num);

        // Pop while the top matches the next expected popped value
        while (
            stack.length > 0 &&
            j < popped.length &&
            stack[stack.length - 1] === popped[j]
        ) {
            stack.pop();
            j++;
        }
    }

    return stack.length === 0;
};

document.getElementById("title").innerText =
    "946. Validate Stack Sequences (JS)";

let output = "";

// Example 1
const pushed1 = [1, 2, 3, 4, 5];
const popped1 = [4, 5, 3, 2, 1];

output += "<b>Example 1 Input:</b><br>";
output += "pushed = [" + pushed1.join(", ") + "], popped = [" + popped1.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += validateStackSequences(pushed1, popped1);
output += "<br><br>";

// Example 2
const pushed2 = [1, 2, 3, 4, 5];
const popped2 = [4, 3, 5, 1, 2];

output += "<b>Example 2 Input:</b><br>";
output += "pushed = [" + pushed2.join(", ") + "], popped = [" + popped2.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += validateStackSequences(pushed2, popped2);

document.getElementById("output").innerHTML = output;