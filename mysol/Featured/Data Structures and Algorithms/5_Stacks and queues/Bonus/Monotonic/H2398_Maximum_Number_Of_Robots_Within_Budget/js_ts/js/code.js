/**
 * @param {number[]} chargeTimes
 * @param {number[]} runningCosts
 * @param {number} budget
 * @return {number}
 */
var maximumRobots = function(chargeTimes, runningCosts, budget) {
    const deque = [];

    let runningSum = 0;
    let left = 0;
    let answer = 0;

    for (let right = 0; right < chargeTimes.length; right++) {
        runningSum += runningCosts[right];

        while (
            deque.length > 0 &&
            chargeTimes[deque[deque.length - 1]] <= chargeTimes[right]
        ) {
            deque.pop();
        }

        deque.push(right);

        while (
            deque.length > 0 &&
            chargeTimes[deque[0]] +
            (right - left + 1) * runningSum > budget
        ) {
            if (deque[0] === left) {
                deque.shift();
            }

            runningSum -= runningCosts[left];
            left++;
        }

        answer = Math.max(answer, right - left + 1);
    }

    return answer;
};

document.getElementById("title").innerText =
    "2398. Maximum Number of Robots Within Budget (JS)";

let output = "";

// Example 1
const chargeTimes1 = [3, 6, 1, 3, 4];
const runningCosts1 = [2, 1, 3, 4, 5];
const budget1 = 25;

output += "<b>Input:</b> chargeTimes = [" + chargeTimes1 +
    "], runningCosts = [" + runningCosts1 + "], budget = " + budget1 + "<br>";
output += "<b>Output:</b> " +
    maximumRobots(chargeTimes1, runningCosts1, budget1);
output += "<br><br>";

// Example 2
const chargeTimes2 = [11, 12, 19];
const runningCosts2 = [10, 8, 7];
const budget2 = 19;

output += "<b>Input:</b> chargeTimes = [" + chargeTimes2 +
    "], runningCosts = [" + runningCosts2 + "], budget = " + budget2 + "<br>";
output += "<b>Output:</b> " +
    maximumRobots(chargeTimes2, runningCosts2, budget2);

document.getElementById("output").innerHTML = output;