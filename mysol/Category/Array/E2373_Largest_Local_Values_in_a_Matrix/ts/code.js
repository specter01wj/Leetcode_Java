function largestLocal(grid) {
    var n = grid.length;
    var maxLocal = Array.from({ length: n - 2 }, function () { return Array(n - 2).fill(0); });
    // Iterate over each cell of the maxLocal matrix
    for (var i = 0; i < n - 2; i++) {
        for (var j = 0; j < n - 2; j++) {
            maxLocal[i][j] = getMaxValue(grid, i, j);
        }
    }
    return maxLocal;
}
function getMaxValue(grid, row, col) {
    var maxVal = Number.MIN_SAFE_INTEGER;
    // Iterate over the 3x3 matrix
    for (var i = row; i <= row + 2; i++) {
        for (var j = col; j <= col + 2; j++) {
            maxVal = Math.max(maxVal, grid[i][j]);
        }
    }
    return maxVal;
}
var input = [[9, 9, 8, 1], [5, 6, 2, 6], [8, 2, 6, 4], [6, 2, 2, 2]];
var output = largestLocal(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
