function letterCombinations(digits: string): string[] {
  if (digits.length === 0) {
      return [];
  }

  const LETTERS: string[] = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
  let combinations: string[] = [];

  function backtrack(index: number, path: string): void {
      if (path.length === digits.length) {
          combinations.push(path);
          return;
      }

      let letters: string = LETTERS[parseInt(digits[index])];
      for (let i = 0; i < letters.length; i++) {
          backtrack(index + 1, path + letters[i]);
      }
  }

  backtrack(0, "");
  return combinations;
};

let input1 = '23';
let output1 = letterCombinations(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

