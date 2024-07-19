function validWordSquare(words) {
    if (!words || words.length === 0) {
        return true;
    }
    const numRows = words.length;
    for (let i = 0; i < numRows; i++) {
        const row = words[i];
        for (let j = 0; j < row.length; j++) {
            // Check if j-th row exists and is long enough
            if (j >= numRows || i >= words[j].length) {
                return false;
            }
            // Compare characters
            if (row[j] !== words[j][i]) {
                return false;
            }
        }
    }
    return true;
}
let nums = ["abcd", "bnrt", "crmy", "dtye"];
let output = validWordSquare(nums);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Output: ' + nums + '<br>Result = ' + output;
