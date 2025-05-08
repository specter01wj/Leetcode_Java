function phonePrefix(numbers: string[]): boolean {
  // Step 1: Sort the array lexicographically
  numbers.sort();

  // Step 2: Compare each number with its next one
  for (let i = 0; i < numbers.length - 1; i++) {
      if (numbers[i + 1].startsWith(numbers[i])) {
          return false;
      }
  }

  return true;
};

const input: string[] = ["001","007","15","00153"];
const results = phonePrefix(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

