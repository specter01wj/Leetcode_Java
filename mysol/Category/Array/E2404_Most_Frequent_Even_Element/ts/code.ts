
function checkDistances(s: string, distance: number[]): boolean {
  // Array to store the first occurrence of each letter
  const firstOccurrence: number[] = Array(26).fill(-1);

  // Loop through the string
  for (let i = 0; i < s.length; i++) {
      const index: number = s.charCodeAt(i) - 'a'.charCodeAt(0); // Calculate the index of the letter in the alphabet

      if (firstOccurrence[index] === -1) {
          // If this is the first occurrence of the letter, store the index
          firstOccurrence[index] = i;
      } else {
          // If this is the second occurrence, calculate the distance
          const actualDistance: number = i - firstOccurrence[index] - 1;
          if (actualDistance !== distance[index]) {
              // If the distance doesn't match the expected distance, return false
              return false;
          }
      }
  }

  // If all letters satisfy the distance requirement, return true
  return true;
};

const input: string = "abaccb";
const distance: number[] = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
const results = checkDistances(input, distance);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

