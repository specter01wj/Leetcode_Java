function createCounter(n) {
    return function () {
        return n++;
    };
}
var input = 10;
var counter = createCounter(input);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output1: ' + counter();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output2: ' + counter();
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output3: ' + counter();
