/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {

    const stack = [];

    for (const c of s) {

        if (stack.length > 0 && Math.abs(stack[stack.length - 1].charCodeAt(0) - c.charCodeAt(0)) === 32) {

            stack.pop();

        } else {

            stack.push(c);
        }
    }

    return stack.join("");
};

document.getElementById("title").innerText =
    "1544. Make The String Great (JS)";

let output = "";

// Example 1
const input1 = "leEeetcode";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += makeGood(input1);
output += "<br><br>";

// Example 2
const input2 = "abBAcC";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += makeGood(input2);
output += "<br><br>";

// Example 3
const input3 = "s";

output += "<b>Example 3 Input:</b><br>";
output += input3;
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += makeGood(input3);

document.getElementById("output").innerHTML = output;