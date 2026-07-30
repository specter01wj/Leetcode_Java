function backspaceCompare(s, t) {
    const stackS = [];
    const stackT = [];
    for (const c of s) {
        if (c !== '#') {
            stackS.push(c);
        }
        else if (stackS.length > 0) {
            stackS.pop();
        }
    }
    for (const c of t) {
        if (c !== '#') {
            stackT.push(c);
        }
        else if (stackT.length > 0) {
            stackT.pop();
        }
    }
    return stackS.join("") === stackT.join("");
}
document.getElementById("title").innerText =
    "844. Backspace String Compare (TS)";
let output = "";
// Example 1
const s1 = "ab#c";
const t1 = "ad#c";
output += "<b>Example 1 Input:</b><br>";
output += 's = "' + s1 + '", t = "' + t1 + '"';
output += "<br><br>";
output += "<b>Example 1 Output:</b><br>";
output += backspaceCompare(s1, t1);
output += "<br><br>";
// Example 2
const s2 = "ab##";
const t2 = "c#d#";
output += "<b>Example 2 Input:</b><br>";
output += 's = "' + s2 + '", t = "' + t2 + '"';
output += "<br><br>";
output += "<b>Example 2 Output:</b><br>";
output += backspaceCompare(s2, t2);
output += "<br><br>";
// Example 3
const s3 = "a#c";
const t3 = "b";
output += "<b>Example 3 Input:</b><br>";
output += 's = "' + s3 + '", t = "' + t3 + '"';
output += "<br><br>";
output += "<b>Example 3 Output:</b><br>";
output += backspaceCompare(s3, t3);
document.getElementById("output").innerHTML = output;
