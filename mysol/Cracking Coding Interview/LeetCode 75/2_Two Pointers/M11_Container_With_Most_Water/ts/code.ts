function isSubsequence(s: string, t: string): boolean {
  let i = 0, j = 0;
  while(i < s.length && j < t.length) {
      if(s.charCodeAt(i) === t.charCodeAt(j)) {
          i++;
      }
      j++;
  }
  
  return i === s.length;
};

let input1 = "abc", input2 = "ahbgdc";
let output1 = isSubsequence(input1, input2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

