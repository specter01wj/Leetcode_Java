function sum(num1: number, num2: number): number {
  return num1 + num2;
};

const num1: number = 12, num2: number = 5;
const results = sum(num1, num2);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(num1, null, 2) + '; ' + JSON.stringify(num2, null, 2)  + '<br>Result = ' + JSON.stringify(results, null, 2);

