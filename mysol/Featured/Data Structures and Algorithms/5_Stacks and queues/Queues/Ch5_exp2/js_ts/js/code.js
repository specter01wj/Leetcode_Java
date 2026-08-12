document.getElementById("title").innerText =
    "Queue Basics (JS)";

const queue = [];

let output = "";

// Offer
output += "<b>=== Offer ===</b><br>";
queue.push(1);
queue.push(2);
queue.push(3);
output += "Queue: [" + queue.join(", ") + "]<br><br>";

// Poll
output += "<b>=== Poll ===</b><br>";
output += "Poll: " + queue.shift() + "<br>";
output += "Queue: [" + queue.join(", ") + "]<br>";

output += "Poll: " + queue.shift() + "<br>";
output += "Queue: [" + queue.join(", ") + "]<br><br>";

// Offer Again
output += "<b>=== Offer Again ===</b><br>";
queue.push(4);
queue.push(5);
output += "Queue: [" + queue.join(", ") + "]<br><br>";

// Peek
output += "<b>=== Peek ===</b><br>";
output += "Front Element: " + queue[0] + "<br>";
output += "Queue: [" + queue.join(", ") + "]<br><br>";

// Size
output += "<b>=== Size ===</b><br>";
output += "Size: " + queue.length + "<br><br>";

// Empty
output += "<b>=== Empty ===</b><br>";
output += "Is Empty? " + (queue.length === 0) + "<br><br>";

// Poll Remaining Elements
output += "<b>=== Poll Remaining Elements ===</b><br>";
while (queue.length > 0) {
    output += "Poll: " + queue.shift() + "<br>";
    output += "Queue: [" + queue.join(", ") + "]<br>";
}
output += "<br>";

// Final Check
output += "<b>=== Final Check ===</b><br>";
output += "Is Empty? " + (queue.length === 0) + "<br>";
output += "Size: " + queue.length;

document.getElementById("output").innerHTML = output;