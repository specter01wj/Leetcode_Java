function checkXMatrix(grid) {
    var n = grid.length;
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < n; j++) {
            if (i === j || i + j === n - 1) {
                // For diagonal elements
                if (grid[i][j] === 0) {
                    return false;
                }
            }
            else {
                // For non-diagonal elements
                if (grid[i][j] !== 0) {
                    return false;
                }
            }
        }
    }
    return true;
}
var input = [[5, 7, 0], [0, 3, 1], [0, 5, 0]];
var output = checkXMatrix(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
