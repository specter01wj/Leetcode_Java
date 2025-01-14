function countPrefixSuffixPairs(words: string[]): number {
  let count = 0;

  for (let i = 0; i < words.length; i++) {
      for (let j = i + 1; j < words.length; j++) {
          if (isPrefixAndSuffix(words[i], words[j])) {
              count++;
          }
      }
  }

  return count;
};

function isPrefixAndSuffix(str1: string, str2: string): boolean {
  // Check if str1 is a prefix and a suffix of str2
  return str2.startsWith(str1) && str2.endsWith(str1);
}

const input: string[] = ["a","aba","ababa","aa"];
const results = countPrefixSuffixPairs(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

