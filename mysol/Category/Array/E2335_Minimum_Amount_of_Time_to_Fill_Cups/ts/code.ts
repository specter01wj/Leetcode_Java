
function fillCups(amount: number[]): number {
  let max = 0, sum = 0;
  for (let i of amount) {
    max = Math.max(i, max);
    sum += i;
  }
  
  return Math.max(max, Math.floor((sum + 1) / 2));
}

let input: number[] = [1,4,2];
let output = fillCups(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


