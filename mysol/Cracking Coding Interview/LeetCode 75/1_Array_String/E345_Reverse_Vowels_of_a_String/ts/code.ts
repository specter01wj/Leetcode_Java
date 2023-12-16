function reverseVowels(s: string): string {
  if(s === null || s.length === 0) {
      return s;
  }
  const vowels: string = "aeiouAEIOU";
  let chars: string[] = s.split("");
  let start: number = 0, end: number = s.length - 1;

  while(start < end) {
      while(start < end && !vowels.includes(chars[start])) {
          start++;
      }
      while(start < end && !vowels.includes(chars[end])) {
          end--;
      }
      [chars[start], chars[end]] = [chars[end], chars[start]]; // Swapping
      start++;
      end--;
  }

  return chars.join("");
};

let input1 = "leetcode";
let output1 = reverseVowels(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

