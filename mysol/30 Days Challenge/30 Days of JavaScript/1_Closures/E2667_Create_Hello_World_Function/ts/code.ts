
function createHelloWorld() {
  return function(...args) {
    return 'Hello World';
  }
}

let input = '';
let output = createHelloWorld()();

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


