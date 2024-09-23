function similarPairs(words: string[]): number {
  const map: Map<number, number> = new Map();

  for (const word of words) {
      let signature: number = 0;
      for (const c of word) {
          const bit: number = c.charCodeAt(0) - 'a'.charCodeAt(0);
          signature |= 1 << bit;
      }
      map.set(signature, (map.get(signature) ?? 0) + 1);
  }

  let count: number = 0;
  for (const freq of map.values()) {
      if (freq >= 2) {
          count += (freq * (freq - 1)) / 2;
      }
  }

  return count;
};

const input: string[] = ["aba","aabb","abcd","bac","aabc"];
const results = similarPairs(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;

