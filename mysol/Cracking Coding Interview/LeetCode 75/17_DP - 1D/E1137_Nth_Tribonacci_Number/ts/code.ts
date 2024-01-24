function tribonacci(n: number): number {
  if (n === 0) return 0;
  if (n === 1 || n === 2) return 1;

  let trib: number[] = [0, 1, 1];
  for (let i = 3; i <= n; i++) {
      trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
  }

  return trib[n];
};

let input1 = 4;
let output1 = tribonacci(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

