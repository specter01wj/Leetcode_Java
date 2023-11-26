
function createCounter(init) {
  let currentValue = init;

  return {
    increment: function() {
      currentValue += 1;
      return currentValue;
    },
    decrement: function() {
      currentValue -= 1;
      return currentValue;
    },
    reset: function() {
      currentValue = init;
      return currentValue;
    }
  }
}

let input = '';
const counter = createCounter(5);
let output1 = counter.increment();
let output2 = counter.reset();
let output3 = counter.decrement();

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + output3.toString();


