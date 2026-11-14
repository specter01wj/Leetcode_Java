class MovingAverage {
  private size: number;
  private queue: number[];
  private sum: number;

  constructor(size: number) {
    this.size = size;
    this.queue = [];
    this.sum = 0;
  }

  next(val: number): number {

    // Remove oldest value when window is full
    if (this.queue.length === this.size) {
      this.sum -= this.queue.shift()!;
    }

    // Add new value
    this.queue.push(val);
    this.sum += val;

    // Return moving average
    return this.sum / this.queue.length;
  }
}

(document.getElementById("title") as HTMLElement).innerText =
  "346. Moving Average from Data Stream (TS)";

let output: string = "";

const movingAverage = new MovingAverage(3);

// Example 1
const input1: number = 1;

output += "<b>Input:</b><br>";
output += input1;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input1);
output += "<br><br>";

// Example 2
const input2: number = 10;

output += "<b>Input:</b><br>";
output += input2;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input2);
output += "<br><br>";

// Example 3
const input3: number = 3;

output += "<b>Input:</b><br>";
output += input3;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input3);
output += "<br><br>";

// Example 4
const input4: number = 5;

output += "<b>Input:</b><br>";
output += input4;
output += "<br>";

output += "<b>Output:</b><br>";
output += movingAverage.next(input4);

(document.getElementById("output") as HTMLElement).innerHTML = output;