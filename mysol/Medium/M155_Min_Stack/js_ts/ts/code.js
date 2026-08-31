class MinStack {
    stack;
    minStack;
    constructor() {
        this.stack = [];
        this.minStack = [];
    }
    push(value) {
        this.stack.push(value);
        if (this.minStack.length === 0 ||
            value <= this.minStack[this.minStack.length - 1]) {
            this.minStack.push(value);
        }
    }
    pop() {
        const value = this.stack.pop();
        if (value === this.minStack[this.minStack.length - 1]) {
            this.minStack.pop();
        }
    }
    top() {
        return this.stack[this.stack.length - 1];
    }
    getMin() {
        return this.minStack[this.minStack.length - 1];
    }
}
document.getElementById("title").innerText =
    "155. Min Stack (TS)";
let output = "";
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
document.getElementById("output").innerHTML = output;
