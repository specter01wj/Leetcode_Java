function maxProfit(prices, fee) {
    if (!prices || prices.length === 0) {
        return 0;
    }
    var cash = 0; // Maximum profit we can have if we do not hold a stock
    var hold = -prices[0]; // Maximum profit we can have if we hold a stock
    for (var i = 1; i < prices.length; i++) {
        cash = Math.max(cash, hold + prices[i] - fee); // Sell the stock
        hold = Math.max(hold, cash - prices[i]); // Buy the stock
    }
    return cash;
}
;
var input1 = [1, 3, 2, 8, 4, 9], fee = 2;
var output1 = maxProfit(input1, fee);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
