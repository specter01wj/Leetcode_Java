
function maxNumberOfApples(weight: number[]): number {
  // Sort the array to prioritize lighter apples
  weight.sort((a, b) => a - b);

  let totalWeight = 0;
  let count = 0;

  // Iterate through the sorted weights
  for (let i = 0; i < weight.length; i++) {
      totalWeight += weight[i];
      if (totalWeight > 5000) {
          break;
      }
      count++;
  }

  return count;
};

const input: number[] = [100,200,150,1000];
const results = maxNumberOfApples(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

