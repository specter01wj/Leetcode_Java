class MyStack {
  private queue: number[];

  constructor() {
    this.queue = [];
  }

  push(x: number): void {
    this.queue.push(x);

    // Move previous elements behind the new element
    const size: number = this.queue.length;

    for (let i = 0; i < size - 1; i++) {
      this.queue.push(this.queue.shift()!);
    }
  }

  pop(): number {
    return this.queue.shift()!;
  }

  top(): number {
    return this.queue[0];
  }

  empty(): boolean {
    return this.queue.length === 0;
  }
}

(document.getElementById("title") as HTMLElement).innerText =
  "225. Implement Stack using Queues (TS)";

let output: string = "";

const myStack = new MyStack();

myStack.push(1);
myStack.push(2);

output += "<b>Input:</b> top()<br>";
output += "<b>Output:</b> " + myStack.top();
output += "<br><br>";

output += "<b>Input:</b> pop()<br>";
output += "<b>Output:</b> " + myStack.pop();
output += "<br><br>";

output += "<b>Input:</b> empty()<br>";
output += "<b>Output:</b> " + myStack.empty();

(document.getElementById("output") as HTMLElement).innerHTML = output;