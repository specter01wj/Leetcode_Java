function countBits(n: number): number[] {
  const ans: number[] = new Array(n + 1);

  for (let i = 0; i <= n; i++) {
      ans[i] = countOnes(i);
  }

  return ans;

  
};

function countOnes(num: number): number {
    return num.toString(2).split('1').length - 1;
}

let input1 = 5;
let output1 = countBits(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

