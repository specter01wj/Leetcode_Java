class StockSpanner {
  private stack: Array<[number, number]>;

  constructor() {
    this.stack = [];
  }

  next(price: number): number {
    let span: number = 1;

    // Remove prices less than or equal to current price
    while (
      this.stack.length > 0 &&
      this.stack[this.stack.length - 1][0] <= price
    ) {
      span += this.stack.pop()![1];
    }

    // Store current price and its span
    this.stack.push([price, span]);

    return span;
  }
}

(document.getElementById("title") as HTMLElement).innerText =
  "901. Online Stock Span (TS)";

let output: string = "";

const stockSpanner = new StockSpanner();

// Example 1
const input1: number = 100;

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += stockSpanner.next(input1);
output += "<br><br>";

// Example 2
const input2: number = 80;

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += stockSpanner.next(input2);
output += "<br><br>";

// Example 3
const input3: number = 60;

output += "<b>Example 3 Input:</b><br>";
output += input3;
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += stockSpanner.next(input3);
output += "<br><br>";

// Example 4
const input4: number = 70;

output += "<b>Example 4 Input:</b><br>";
output += input4;
output += "<br><br>";

output += "<b>Example 4 Output:</b><br>";
output += stockSpanner.next(input4);
output += "<br><br>";

// Example 5
const input5: number = 60;

output += "<b>Example 5 Input:</b><br>";
output += input5;
output += "<br><br>";

output += "<b>Example 5 Output:</b><br>";
output += stockSpanner.next(input5);
output += "<br><br>";

// Example 6
const input6: number = 75;

output += "<b>Example 6 Input:</b><br>";
output += input6;
output += "<br><br>";

output += "<b>Example 6 Output:</b><br>";
output += stockSpanner.next(input6);
output += "<br><br>";

// Example 7
const input7: number = 85;

output += "<b>Example 7 Input:</b><br>";
output += input7;
output += "<br><br>";

output += "<b>Example 7 Output:</b><br>";
output += stockSpanner.next(input7);

(document.getElementById("output") as HTMLElement).innerHTML = output;