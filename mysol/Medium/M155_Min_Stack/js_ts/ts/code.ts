class MinStack {
  private stack: number[];
  private minStack: number[];

  constructor() {
    this.stack = [];
    this.minStack = [];
  }

  push(value: number): void {
    this.stack.push(value);

    if (
      this.minStack.length === 0 ||
      value <= this.minStack[this.minStack.length - 1]
    ) {
      this.minStack.push(value);
    }
  }

  pop(): void {
    const value: number = this.stack.pop()!;

    if (value === this.minStack[this.minStack.length - 1]) {
      this.minStack.pop();
    }
  }

  top(): number {
    return this.stack[this.stack.length - 1];
  }

  getMin(): number {
    return this.minStack[this.minStack.length - 1];
  }
}

(document.getElementById("title") as HTMLElement).innerText =
  "155. Min Stack (TS)";

let output: string = "";

const minStack = new MinStack();

minStack.push(-2);
minStack.push(0);
minStack.push(-3);

output += "<b>Input:</b> getMin()<br>";
output += "<b>Output:</b> " + minStack.getMin();
output += "<br><br>";

minStack.pop();

output += "<b>Input:</b> top()<br>";
output += "<b>Output:</b> " + minStack.top();
output += "<br><br>";

output += "<b>Input:</b> getMin()<br>";
output += "<b>Output:</b> " + minStack.getMin();

(document.getElementById("output") as HTMLElement).innerHTML = output;