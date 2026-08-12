var RecentCounter = function() {
    this.requests = [];
};

/** 
 * @param {number} t
 * @return {number}
 */
RecentCounter.prototype.ping = function(t) {

    // Add new request timestamp
    this.requests.push(t);

    // Remove older requests outside the 3000ms window
    while (this.requests.length > 0 && this.requests[0] < t - 3000) {
        this.requests.shift();
    }

    // Return the number of requests in the window
    return this.requests.length;
};

document.getElementById("title").innerText =
    "933. Number of Recent Calls (JS)";

let output = "";

const recentCounter = new RecentCounter();

// Example 1
const input1 = 1;

output += "<b>Input:</b><br>";
output += input1;
output += "<br>";

output += "<b>Output:</b><br>";
output += recentCounter.ping(input1);
output += "<br><br>";

// Example 2
const input2 = 100;

output += "<b>Input:</b><br>";
output += input2;
output += "<br>";

output += "<b>Output:</b><br>";
output += recentCounter.ping(input2);
output += "<br><br>";

// Example 3
const input3 = 3001;

output += "<b>Input:</b><br>";
output += input3;
output += "<br>";

output += "<b>Output:</b><br>";
output += recentCounter.ping(input3);
output += "<br><br>";

// Example 4
const input4 = 3002;

output += "<b>Input:</b><br>";
output += input4;
output += "<br>";

output += "<b>Output:</b><br>";
output += recentCounter.ping(input4);

document.getElementById("output").innerHTML = output;