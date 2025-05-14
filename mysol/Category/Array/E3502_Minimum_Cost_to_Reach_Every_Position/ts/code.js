function minCosts(cost) {
    const n = cost.length;
    const answer = new Array(n).fill(Infinity);
    for (let i = 0; i < n; i++) {
        // Pay cost[i] to reach person i
        answer[i] = Math.min(answer[i], cost[i]);
        // From i, move forward for free, and update cheaper cost if possible
        for (let j = i + 1; j < n; j++) {
            if (answer[j] > cost[i]) {
                answer[j] = cost[i];
            }
            else {
                break; // No need to update further if already cheaper
            }
        }
    }
    return answer;
}
;
const input = [5, 3, 4, 1, 3, 2];
const results = minCosts(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
