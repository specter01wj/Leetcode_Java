function letterCombinations(digits) {
    if (digits.length === 0) {
        return [];
    }
    var LETTERS = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
    var combinations = [];
    function backtrack(index, path) {
        if (path.length === digits.length) {
            combinations.push(path);
            return;
        }
        var letters = LETTERS[parseInt(digits[index])];
        for (var i = 0; i < letters.length; i++) {
            backtrack(index + 1, path + letters[i]);
        }
    }
    backtrack(0, "");
    return combinations;
}
;
var input1 = '23';
var output1 = letterCombinations(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
