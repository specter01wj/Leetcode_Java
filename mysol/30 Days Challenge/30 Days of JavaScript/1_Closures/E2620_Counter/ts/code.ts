
function createCounter(n) {
  return function() {
    return n++;
  }
}

let input = 10;
let counter = createCounter(input);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output1: ' + counter();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output2: ' + counter();

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output3: ' + counter();


