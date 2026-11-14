var MovingAverage = function(size) {
    this.size = size;
    this.queue = [];
    this.sum = 0;
};

MovingAverage.prototype.next = function(val) {

    // Remove oldest value when window is full
    if (this.queue.length === this.size) {
        this.sum -= this.queue.shift();
    }

    // Add new value
    this.queue.push(val);
    this.sum += val;

    // Return moving average
    return this.sum / this.queue.length;
};

document.getElementById("title").innerText =
    "346. Moving Average from Data Stream (JS)";

let output = "";

const movingAverage = new MovingAverage(3);

// Example 1
const input1 = 1;

output += "<b>Input:</b><br>";
output += input1;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input1);
output += "<br><br>";

// Example 2
const input2 = 10;

output += "<b>Input:</b><br>";
output += input2;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input2);
output += "<br><br>";

// Example 3
const input3 = 3;

output += "<b>Input:</b><br>";
output += input3;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input3);
output += "<br><br>";

// Example 4
const input4 = 5;

output += "<b>Input:</b><br>";
output += input4;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input4);

document.getElementById("output").innerHTML = output;