
function indexPairs(text: string, words: string[]): number[][] {
  let result: number[][] = [];

  // Iterate through each position in the text
  for (let i = 0; i < text.length; i++) {
      // Check each word in the words array
      for (let word of words) {
          if (text.startsWith(word, i)) {
              // If the word matches the substring starting from index i, add the pair
              result.push([i, i + word.length - 1]);
          }
      }
  }

  // Sort the result array
  result.sort((a, b) => {
      if (a[0] === b[0]) {
          return a[1] - b[1];
      } else {
          return a[0] - b[0];
      }
  });

  return result;
};

const text: string = "thestoryofleetcodeandme";
const words: string[] = ["story", "fleet", "leetcode"];
const results = indexPairs(text, words);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: text - ' + text + '; words - ' + words + '<br>Result = ' + results;

