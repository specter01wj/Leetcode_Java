var MyQueue = function() {
    this.inputStack = [];
    this.outputStack = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.inputStack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    if (this.outputStack.length === 0) {
        while (this.inputStack.length > 0) {
            this.outputStack.push(this.inputStack.pop());
        }
    }

    return this.outputStack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if (this.outputStack.length === 0) {
        while (this.inputStack.length > 0) {
            this.outputStack.push(this.inputStack.pop());
        }
    }

    return this.outputStack[this.outputStack.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.inputStack.length === 0 && this.outputStack.length === 0;
};

document.getElementById("title").innerText =
    "232. Implement Queue using Stacks (JS)";

let output = "";

const myQueue = new MyQueue();

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

document.getElementById("output").innerHTML = output;