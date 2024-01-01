function decodeString(s: string): string {
  let counts: number[] = [];
  let resultStack: string[][] = [];
  resultStack.push([]);
  let k: number = 0;

  for (let ch of s) {
      if (ch >= '0' && ch <= '9') {
          k = k * 10 + parseInt(ch, 10);
      } else if (ch === '[') {
          counts.push(k);
          resultStack.push([]);
          k = 0;
      } else if (ch === ']') {
          let temp: string = resultStack.pop().join('');
          let count: number = counts.pop();
          resultStack[resultStack.length - 1].push(temp.repeat(count));
      } else {
          resultStack[resultStack.length - 1].push(ch);
      }
  }

  return resultStack.pop().join('');
};

let input1 = "3[a2[c]]";
let output1 = decodeString(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

