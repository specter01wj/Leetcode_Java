function getLongestSubsequence(words: string[], groups: number[]): string[] {
  const result: string[] = [];
  const n = words.length;

  // Add the first word to the result
  result.push(words[0]);

  // Iterate through the array and ensure alternating groups
  for (let i = 1; i < n; i++) {
      if (groups[i] !== groups[i - 1]) {
          result.push(words[i]);
      }
  }

  return result;
};

const input: string[] = ["e","a","b"];
const groups: number[] = [0,0,1];
const results = getLongestSubsequence(input, groups);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

