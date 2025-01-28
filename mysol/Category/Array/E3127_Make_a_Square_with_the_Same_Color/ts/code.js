function canMakeSquare(grid) {
    // Loop through all possible 2x2 squares in the 3x3 grid
    for (let i = 0; i < 2; i++) {
        for (let j = 0; j < 2; j++) {
            // Count the occurrences of 'B' and 'W' in the current 2x2 square
            let countB = 0;
            let countW = 0;
            for (let x = i; x < i + 2; x++) {
                for (let y = j; y < j + 2; y++) {
                    if (grid[x][y] === 'B') {
                        countB++;
                    }
                    else {
                        countW++;
                    }
                }
            }
            // Check if the current 2x2 square can be made uniform by changing at most one cell
            if (countB >= 3 || countW >= 3) {
                return true;
            }
        }
    }
    return false;
}
;
const input = [["B", "W", "B"], ["B", "W", "W"], ["B", "W", "B"]];
const results = canMakeSquare(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
