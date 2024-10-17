function vowelStrings(words: string[], left: number, right: number): number {
  let count = 0;
  const vowels = "aeiou";

  for (let i = left; i <= right; i++) {
      const word = words[i];
      if (vowels.includes(word.charAt(0)) && vowels.includes(word.charAt(word.length - 1))) {
          count++;
      }
  }

  return count;
};

const input: string[] = ["hey","aeo","mu","ooo","artro"];
const left = 1, right = 4;
const results = vowelStrings(input, left, right);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

