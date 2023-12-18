function reverseWords(s: string): string {
  s = s.trim();
  let words: string[] = s.split(/\s+/).reverse();
  return words.join(' ');
};

let input1 = "the sky is blue";
let output1 = reverseWords(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

