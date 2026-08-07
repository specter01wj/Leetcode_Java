/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {

    const stack = [];
    const folders = path.split("/");

    for (const folder of folders) {
        if (folder === "" || folder === ".") {
            continue;
        }

        if (folder === "..") {
            if (stack.length > 0) {
                stack.pop();
            }
        } else {
            stack.push(folder);
        }
    }

    return "/" + stack.join("/");
};

document.getElementById("title").innerText =
    "71. Simplify Path (JS)";

let output = "";

// Example 1
const input1 = "/home/";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += simplifyPath(input1);
output += "<br><br>";

// Example 2
const input2 = "/home//foo/";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += simplifyPath(input2);
output += "<br><br>";

// Example 3
const input3 = "/home/user/Documents/../Pictures";

output += "<b>Example 3 Input:</b><br>";
output += input3;
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += simplifyPath(input3);
output += "<br><br>";

// Example 4
const input4 = "/../";

output += "<b>Example 4 Input:</b><br>";
output += input4;
output += "<br><br>";

output += "<b>Example 4 Output:</b><br>";
output += simplifyPath(input4);
output += "<br><br>";

// Example 5
const input5 = "/.../a/../b/c/../d/./";

output += "<b>Example 5 Input:</b><br>";
output += input5;
output += "<br><br>";

output += "<b>Example 5 Output:</b><br>";
output += simplifyPath(input5);

document.getElementById("output").innerHTML = output;