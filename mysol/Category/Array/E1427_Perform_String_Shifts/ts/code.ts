
function countElements(arr: number[]): number {
  // Create a Set to store the unique elements from the array
  const elementsSet: Set<number> = new Set(arr);
  
  let count: number = 0;
  // Loop through the array and check if num + 1 exists in the set
  for (let num of arr) {
      if (elementsSet.has(num + 1)) {
          count++;
      }
  }
  
  return count;
};

const input: number[] = [1,2,3];
const results = countElements(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

