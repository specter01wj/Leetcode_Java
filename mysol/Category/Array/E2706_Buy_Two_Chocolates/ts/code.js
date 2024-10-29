function buyChoco(prices, money) {
    // Sort the prices to get the two cheapest chocolates
    prices.sort((a, b) => a - b);
    // Calculate the sum of the two cheapest chocolates
    const cost = prices[0] + prices[1];
    // Check if the total cost is within the available money
    if (cost <= money) {
        return money - cost; // Return the remaining money
    }
    else {
        return money; // Not enough money, return original amount
    }
}
;
const input = [3, 2, 3], money = 2;
const inputCopy = [...input];
const results = buyChoco(inputCopy, money);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
