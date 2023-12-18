function compress(chars: string[]): number {
  let indexAns = 0, index = 0;

  while (index < chars.length) {
      let currentChar = chars[index];
      let count = 0;

      while (index < chars.length && chars[index] === currentChar) {
          index++;
          count++;
      }

      chars[indexAns++] = currentChar;

      if (count !== 1) {
          let countStr = count.toString();
          for (let i = 0; i < countStr.length; i++) {
              chars[indexAns++] = countStr[i];
          }
      }
  }

  return indexAns;
};

let input1 = ["a","a","b","b","c","c","c"];
let output1 = compress(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

