function mergeAlternately(word1: string, word2: string): string {
  let n = word1.length, m = word2.length, i = 0, j = 0;
  let res = '';

  while (i < n || j < m) {
      if (i < n) {
          res += word1[i++];
      }
      if (j < m) {
          res += word2[j++];
      }
  }

  return res;
}

let word1 = "abcd", word2 = "pq";
let output1 = mergeAlternately(word1, word2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

