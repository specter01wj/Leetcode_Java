/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {

    const stack = [];

    for (const c of s) {

        if (c === "*") {
            stack.pop();
        } else {
            stack.push(c);
        }
    }

    return stack.join("");
};

document.getElementById("title").innerText =
    "2390. Removing Stars From a String (JS)";

let output = "";

// Example 1
const input1 = "leet**cod*e";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += removeStars(input1);
output += "<br><br>";

// Example 2
const input2 = "erase*****";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += removeStars(input2);

document.getElementById("output").innerHTML = output;