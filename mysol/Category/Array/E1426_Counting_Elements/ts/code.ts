
function transformArray(arr: number[]): number[] {
  let changed = true;

  while (changed) {
      changed = false;
      let temp = arr.slice(); // Create a copy of the array

      for (let i = 1; i < arr.length - 1; i++) {
          if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
              temp[i]++;
              changed = true;
          } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
              temp[i]--;
              changed = true;
          }
      }

      arr = temp; // Update the original array with the modified values
  }

  return arr;
};

const input: number[] = [6, 2, 3, 4];
const results = transformArray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

