function maximumValue(strs: string[]): number {
  let maxValue = 0;

  for (let str of strs) {
      let currentValue: number;

      // Check if the string is composed only of digits
      if (/^\d+$/.test(str)) {
          // Convert string to its numeric value
          currentValue = parseInt(str, 10);
      } else {
          // Otherwise, the value is the length of the string
          currentValue = str.length;
      }

      // Update maxValue if the current value is greater
      maxValue = Math.max(maxValue, currentValue);
  }

  return maxValue;
};

const input: string[] = ["alic3","bob","3","4","00000"];
const results = maximumValue(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

