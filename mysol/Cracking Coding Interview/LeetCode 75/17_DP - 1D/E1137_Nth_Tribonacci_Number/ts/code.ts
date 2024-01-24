function combinationSum3(k: number, n: number): number[][] {
  let result: number[][] = [];
  backtrack(result, [], k, n, 1);
  return result;
};

function backtrack(result: number[][], current: number[], k: number, remain: number, start: number): void {
  if (remain === 0 && current.length === k) {
      result.push([...current]);
      return;
  }

  for (let i = start; i <= 9; i++) {
      if (remain - i < 0 || current.length >= k) {
          break;
      }
      current.push(i);
      backtrack(result, current, k, remain - i, i + 1);
      current.pop();
  }
}

let k = 3, n = 7;
let output1 = combinationSum3(k, n);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

