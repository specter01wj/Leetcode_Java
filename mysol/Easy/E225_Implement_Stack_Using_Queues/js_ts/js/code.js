var MyStack = function() {
    this.queue = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function(x) {
    this.queue.push(x);

    // Move previous elements behind the new element
    const size = this.queue.length;

    for (let i = 0; i < size - 1; i++) {
        this.queue.push(this.queue.shift());
    }
};

/**
 * @return {number}
 */
MyStack.prototype.pop = function() {
    return this.queue.shift();
};

/**
 * @return {number}
 */
MyStack.prototype.top = function() {
    return this.queue[0];
};

/**
 * @return {boolean}
 */
MyStack.prototype.empty = function() {
    return this.queue.length === 0;
};

document.getElementById("title").innerText =
    "225. Implement Stack using Queues (JS)";

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