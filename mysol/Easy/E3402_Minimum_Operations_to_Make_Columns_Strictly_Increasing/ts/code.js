function minimumOperations(grid) {
    const m = grid.length;
    const n = grid[0].length;
    let operations = 0;
    for (let col = 0; col < n; col++) {
        for (let row = 1; row < m; row++) {
            if (grid[row][col] <= grid[row - 1][col]) {
                const increment = grid[row - 1][col] + 1 - grid[row][col];
                operations += increment;
                grid[row][col] += increment; // update current cell
            }
        }
    }
    return operations;
}
;
const input = [[3, 2], [1, 3], [3, 4], [0, 1]];
const inputCopy = input.map(row => [...row]);
const results = minimumOperations(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(inputCopy, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
