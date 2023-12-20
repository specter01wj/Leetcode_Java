function maxVowels(s: string, k: number): number {
  let maxVowels = 0;
  let currentVowels = 0;

  // Count vowels in the first window
  for (let i = 0; i < k; i++) {
      if (isVowel(s[i])) {
          currentVowels++;
      }
  }

  maxVowels = currentVowels;

  // Slide the window and update the count
  for (let i = k; i < s.length; i++) {
      if (isVowel(s[i])) {
          currentVowels++;
      }
      if (isVowel(s[i - k])) {
          currentVowels--;
      }

      maxVowels = Math.max(maxVowels, currentVowels);
  }

  return maxVowels;
};

// Function to check if a character is a vowel
function isVowel(ch: string): boolean {
  return 'aeiou'.includes(ch);
}

let input1 = "abciiidef", k = 3;
let output1 = maxVowels(input1, 4);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

