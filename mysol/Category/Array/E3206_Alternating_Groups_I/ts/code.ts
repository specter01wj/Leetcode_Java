function tripletCount(a: number[], b: number[], c: number[]): number {
  let count = 0;

  for (let numA of a) {
      for (let numB of b) {
          for (let numC of c) {
              let xorValue = numA ^ numB ^ numC;
              if (countSetBits(xorValue) % 2 === 0) {
                  count++;
              }
          }
      }
  }

  return count;
};

function countSetBits(n: number): number {
  let count = 0;
  while (n > 0) {
      count += n & 1;
      n >>= 1;
  }
  return count;
}

const a: number[] = [1,1], b: number[] = [2,3], c: number[] = [1,5];
const results = tripletCount(a, b, c);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(a, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

