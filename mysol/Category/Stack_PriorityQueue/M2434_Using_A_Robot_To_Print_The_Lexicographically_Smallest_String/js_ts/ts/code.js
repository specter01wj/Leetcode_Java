function robotWithString(s) {
    const count = new Array(26).fill(0);
    for (const c of s) {
        count[c.charCodeAt(0) - 97]++;
    }
    const stack = [];
    let answer = "";
    let smallest = 0;
    for (const c of s) {
        stack.push(c);
        count[c.charCodeAt(0) - 97]--;
        // Find the smallest remaining character in s
        while (smallest < 26 && count[smallest] === 0) {
            smallest++;
        }
        // Output characters that are no larger than the smallest remaining character
        while (stack.length > 0 &&
            (smallest === 26 ||
                stack[stack.length - 1].charCodeAt(0) - 97 <= smallest)) {
            answer += stack.pop();
        }
    }
    return answer;
}
document.getElementById("title").innerText =
    "2434. Using a Robot to Print the Lexicographically Smallest String (TS)";
let output = "";
// Example 1
const input1 = "zza";
output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";
output += "<b>Example 1 Output:</b><br>";
output += robotWithString(input1);
output += "<br><br>";
// Example 2
const input2 = "bac";
output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";
output += "<b>Example 2 Output:</b><br>";
output += robotWithString(input2);
output += "<br><br>";
// Example 3
const input3 = "bdda";
output += "<b>Example 3 Input:</b><br>";
output += input3;
output += "<br><br>";
output += "<b>Example 3 Output:</b><br>";
output += robotWithString(input3);
document.getElementById("output").innerHTML = output;
