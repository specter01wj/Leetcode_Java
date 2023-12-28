function equalPairs(grid) {
    var n = grid.length;
    var count = 0;
    for (var row = 0; row < n; row++) {
        for (var col = 0; col < n; col++) {
            var r = 0;
            while (r < n && grid[row][r] === grid[r][col]) {
                r++;
            }
            if (r === n) {
                count++;
            }
        }
    }
    return count;
}
;
var input1 = [[3, 2, 1], [1, 7, 6], [2, 7, 7]];
var output1 = equalPairs(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
