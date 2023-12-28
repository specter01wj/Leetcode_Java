function closeStrings(word1: string, word2: string): boolean {
  if (word1.length !== word2.length) {
      return false;
  }

  const freq1: number[] = new Array(26).fill(0);
  const freq2: number[] = new Array(26).fill(0);
  const present1: Set<string> = new Set();
  const present2: Set<string> = new Set();

  for (const char of word1) {
      const index: number = char.charCodeAt(0) - 'a'.charCodeAt(0);
      freq1[index]++;
      present1.add(char);
  }

  for (const char of word2) {
      const index: number = char.charCodeAt(0) - 'a'.charCodeAt(0);
      freq2[index]++;
      present2.add(char);
  }

  if (present1.size !== present2.size || ![...present1].every(char => present2.has(char))) {
      return false;
  }

  freq1.sort((a, b) => a - b);
  freq2.sort((a, b) => a - b);

  return freq1.every((val, index) => val === freq2[index]);
};

let word1 = "abc", word2 = "bca";
let output1 = closeStrings(word1, word2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

