class MyQueue {

  private inputStack: number[];
  private outputStack: number[];

  constructor() {
    this.inputStack = [];
    this.outputStack = [];
  }

  push(x: number): void {
    this.inputStack.push(x);
  }

  pop(): number {
    if (this.outputStack.length === 0) {
      while (this.inputStack.length > 0) {
        this.outputStack.push(this.inputStack.pop()!);
      }
    }

    return this.outputStack.pop()!;
  }

  peek(): number {
    if (this.outputStack.length === 0) {
      while (this.inputStack.length > 0) {
        this.outputStack.push(this.inputStack.pop()!);
      }
    }

    return this.outputStack[this.outputStack.length - 1];
  }

  empty(): boolean {
    return this.inputStack.length === 0 && this.outputStack.length === 0;
  }
}

(document.getElementById("title") as HTMLElement).innerText =
  "232. Implement Queue using Stacks (TS)";

let output: string = "";

const myQueue: MyQueue = new MyQueue();

// Push 1
output += "<b>Input: push(1)</b><br>";
myQueue.push(1);
output += "<br>";

// Push 2
output += "<b>Input: push(2)</b><br>";
myQueue.push(2);
output += "<br>";

// Peek
output += "<b>Input: peek()</b><br>";
output += "Output: " + myQueue.peek();
output += "<br><br>";

// Pop
output += "<b>Input: pop()</b><br>";
output += "Output: " + myQueue.pop();
output += "<br><br>";

// Empty
output += "<b>Input: empty()</b><br>";
output += "Output: " + myQueue.empty();

(document.getElementById("output") as HTMLElement).innerHTML = output;