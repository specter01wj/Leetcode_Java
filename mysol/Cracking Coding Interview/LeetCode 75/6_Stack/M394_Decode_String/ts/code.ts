function removeStars(s: string): string {
  let stack: string[] = [];

  for (let ch of s) {
      if (ch === '*') {
          stack.pop();
      } else {
          stack.push(ch);
      }
  }

  return stack.join('');
};

let input1 = "leet**cod*e";
let output1 = removeStars(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

