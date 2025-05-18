function maximumWealth(accounts) {
    let maxWealth = 0;
    for (let customer of accounts) {
        const sum = customer.reduce((a, b) => a + b, 0);
        maxWealth = Math.max(maxWealth, sum);
    }
    return maxWealth;
}
;
const input = [[1, 5], [7, 3], [3, 5]];
const results = maximumWealth(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
