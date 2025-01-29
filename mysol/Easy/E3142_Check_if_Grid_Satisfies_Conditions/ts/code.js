function satisfiesConditions(grid) {
    const m = grid.length;
    const n = grid[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // Check if grid[i][j] is equal to the cell below it
            if (i < m - 1 && grid[i][j] !== grid[i + 1][j]) {
                return false;
            }
            // Check if grid[i][j] is different from the cell to its right
            if (j < n - 1 && grid[i][j] === grid[i][j + 1]) {
                return false;
            }
        }
    }
    return true;
}
;
const input = [[1, 0, 2], [1, 0, 2]];
const results = satisfiesConditions(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
