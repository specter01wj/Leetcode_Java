function deleteGreatestValue(grid) {
    // Sort each row in ascending order
    for (const row of grid) {
        row.sort((a, b) => a - b);
    }
    let ans = 0;
    const n = grid[0].length;
    // Iterate from the last column to the first
    for (let k = n - 1; k >= 0; k--) {
        let maxVal = 0;
        // Find the maximum value in the k-th column
        for (let i = 0; i < grid.length; i++) {
            const val = grid[i][k];
            if (val > maxVal) {
                maxVal = val;
            }
        }
        ans += maxVal;
    }
    return ans;
}
;
const input = [[1, 2, 4], [3, 3, 1]];
const inputCopy = input.map(row => [...row]);
const results = deleteGreatestValue(inputCopy);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
