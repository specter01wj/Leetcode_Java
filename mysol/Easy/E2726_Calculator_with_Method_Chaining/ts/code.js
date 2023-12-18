var Calculator = /** @class */ (function () {
    function Calculator(value) {
        this.result = value;
    }
    Calculator.prototype.add = function (value) {
        this.result += value;
        return this;
    };
    Calculator.prototype.subtract = function (value) {
        this.result -= value;
        return this;
    };
    Calculator.prototype.multiply = function (value) {
        this.result *= value;
        return this;
    };
    Calculator.prototype.divide = function (value) {
        if (value === 0) {
            throw new Error("Division by zero is not allowed");
        }
        this.result /= value;
        return this;
    };
    Calculator.prototype.power = function (value) {
        var _a;
        (_a = this).result = Math.pow(_a.result, value);
        return this;
    };
    Calculator.prototype.getResult = function () {
        return this.result;
    };
    return Calculator;
}());
var input1 = '';
var output1 = new Calculator(10).add(5).subtract(7).getResult(); // 10 + 5 - 7 = 8
var output2 = new Calculator(2).multiply(5).power(2).getResult(); // (2 * 5) ^ 2 = 100
// let output3 = new Calculator(20).divide(0).getResult(); // 20 / 0 
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
// let webHeading3 = document.querySelector('#t3');
// webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
