class MyStack {
    queue;
    constructor() {
        this.queue = [];
    }
    push(x) {
        this.queue.push(x);
        // Move previous elements behind the new element
        const size = this.queue.length;
        for (let i = 0; i < size - 1; i++) {
            this.queue.push(this.queue.shift());
        }
    }
    pop() {
        return this.queue.shift();
    }
    top() {
        return this.queue[0];
    }
    empty() {
        return this.queue.length === 0;
    }
}
document.getElementById("title").innerText =
    "225. Implement Stack using Queues (TS)";
let output = "";
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
document.getElementById("output").innerHTML = output;
