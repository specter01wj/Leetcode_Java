function totalCost(costs, k, candidates) {
    var headWorkers = [];
    var tailWorkers = [];
    // Initialize the queues
    for (var i = 0; i < candidates; i++) {
        headWorkers.push(costs[i]);
    }
    for (var i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
        tailWorkers.push(costs[i]);
    }
    headWorkers.sort(function (a, b) { return a - b; });
    tailWorkers.sort(function (a, b) { return a - b; });
    var answer = 0;
    var nextHead = candidates;
    var nextTail = costs.length - 1 - candidates;
    for (var i = 0; i < k; i++) {
        if (tailWorkers.length === 0 || (headWorkers.length > 0 && headWorkers[0] <= tailWorkers[0])) {
            answer += headWorkers.shift();
            if (nextHead <= nextTail) {
                insertSorted(headWorkers, costs[nextHead]);
                nextHead++;
            }
        }
        else {
            answer += tailWorkers.shift();
            if (nextHead <= nextTail) {
                insertSorted(tailWorkers, costs[nextTail]);
                nextTail--;
            }
        }
    }
    return answer;
}
;
function insertSorted(arr, value) {
    var index = arr.findIndex(function (x) { return x > value; });
    if (index === -1) {
        arr.push(value);
    }
    else {
        arr.splice(index, 0, value);
    }
}
var input1 = [17, 12, 10, 2, 7, 2, 11, 20, 8], k = 3, candidates = 4;
var output1 = totalCost(input1, k, candidates);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
