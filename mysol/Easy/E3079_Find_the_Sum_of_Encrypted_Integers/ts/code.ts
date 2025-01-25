function sumOfEncryptedInt(nums: number[]): number {
  let sum = 0;

  nums.forEach(num => {
      let maxDigit = 0;
      let temp = num;

      // Find the largest digit in the current number
      while (temp > 0) {
          let digit = temp % 10;
          maxDigit = Math.max(maxDigit, digit);
          temp = Math.floor(temp / 10);
      }

      // Replace all digits with the largest digit
      let encryptedValue = 0;
      let placeValue = 1;
      temp = num; // Reset temp to the original number

      while (temp > 0) {
          encryptedValue += maxDigit * placeValue;
          placeValue *= 10;
          temp = Math.floor(temp / 10);
      }

      // Add the encrypted value to the sum
      sum += encryptedValue;
  });

  return sum;
};

const input: number[] = [10,21,31];
const results = sumOfEncryptedInt(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

