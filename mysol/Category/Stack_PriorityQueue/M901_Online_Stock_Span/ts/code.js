var StockSpanner = /** @class */ (function () {
    function StockSpanner() {
        this.stack = [];
    }
    StockSpanner.prototype.next = function (price) {
        var span = 1; // The span is at least 1 for the current price
        // While the stack is not empty and the current price is greater or equal
        // to the price at the top of the stack
        while (this.stack.length > 0 && this.stack[this.stack.length - 1][0] <= price) {
            // Add the span of the popped element to the current span
            span += this.stack.pop()[1];
        }
        // Push the current price and its span onto the stack
        this.stack.push([price, span]);
        return span;
    };
    return StockSpanner;
}());
var obj = new StockSpanner();
var output1 = [];
output1.push(obj.next(100)); // Output: 1
output1.push(obj.next(80)); // Output: 1
output1.push(obj.next(60)); // Output: 1
output1.push(obj.next(70)); // Output: 2
output1.push(obj.next(60)); // Output: 1
output1.push(obj.next(75)); // Output: 4
output1.push(obj.next(85)); // Output: 6
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
