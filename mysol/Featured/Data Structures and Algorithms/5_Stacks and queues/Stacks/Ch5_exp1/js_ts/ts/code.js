document.getElementById("title").innerText =
    "Stack Basics (TS)";
const stack = [];
let output = "";
// Push
output += "<b>=== Push ===</b><br>";
stack.push(1);
stack.push(2);
stack.push(3);
output += "Stack: [" + stack.join(", ") + "]<br><br>";
// Pop
output += "<b>=== Pop ===</b><br>";
output += "Pop: " + stack.pop() + "<br>";
output += "Stack: [" + stack.join(", ") + "]<br>";
output += "Pop: " + stack.pop() + "<br>";
output += "Stack: [" + stack.join(", ") + "]<br><br>";
// Push Again
output += "<b>=== Push Again ===</b><br>";
stack.push(5);
output += "Stack: [" + stack.join(", ") + "]<br><br>";
// Peek
output += "<b>=== Peek ===</b><br>";
output += "Top Element: " + stack[stack.length - 1] + "<br>";
output += "Stack: [" + stack.join(", ") + "]<br><br>";
// Size
output += "<b>=== Size ===</b><br>";
output += "Size: " + stack.length + "<br><br>";
// Empty
output += "<b>=== Empty ===</b><br>";
output += "Is Empty? " + (stack.length === 0) + "<br><br>";
// Pop Remaining Elements
output += "<b>=== Pop Remaining Elements ===</b><br>";
while (stack.length > 0) {
    output += "Pop: " + stack.pop() + "<br>";
    output += "Stack: [" + stack.join(", ") + "]<br>";
}
output += "<br>";
// Final Check
output += "<b>=== Final Check ===</b><br>";
output += "Is Empty? " + (stack.length === 0) + "<br>";
output += "Size: " + stack.length;
document.getElementById("output").innerHTML = output;
