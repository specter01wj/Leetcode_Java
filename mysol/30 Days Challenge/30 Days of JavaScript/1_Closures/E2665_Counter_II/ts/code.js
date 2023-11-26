function createCounter(init) {
    var currentValue = init;
    return {
        increment: function () {
            currentValue += 1;
            return currentValue;
        },
        decrement: function () {
            currentValue -= 1;
            return currentValue;
        },
        reset: function () {
            currentValue = init;
            return currentValue;
        }
    };
}
var input = '';
var counter = createCounter(5);
var output1 = counter.increment();
var output2 = counter.reset();
var output3 = counter.decrement();
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + output3.toString();
