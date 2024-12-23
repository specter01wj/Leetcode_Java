function findMissingAndRepeatedValues(grid) {
    const n = grid.length;
    const nSquared = n * n;
    // Create a frequency array to track occurrences of each number.
    const frequency = new Array(nSquared + 1).fill(0);
    // Count the occurrences of each number in the grid.
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            frequency[grid[i][j]]++;
        }
    }
    let repeated = -1;
    let missing = -1;
    // Find the repeated and missing numbers.
    for (let i = 1; i <= nSquared; i++) {
        if (frequency[i] === 2) {
            repeated = i;
        }
        else if (frequency[i] === 0) {
            missing = i;
        }
        // If both values are found, break early.
        if (repeated !== -1 && missing !== -1) {
            break;
        }
    }
    // Return the result as an array.
    return [repeated, missing];
}
;
const input = [[9, 1, 7], [8, 9, 2], [3, 4, 6]];
const results = findMissingAndRepeatedValues(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
