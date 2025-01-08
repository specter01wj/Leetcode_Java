function modifiedMatrix(matrix) {
    const m = matrix.length;
    const n = matrix[0].length;
    // Step 1: Determine maximum values for each column
    const maxInColumn = Array(n).fill(Number.MIN_SAFE_INTEGER);
    for (let j = 0; j < n; j++) {
        for (let i = 0; i < m; i++) {
            maxInColumn[j] = Math.max(maxInColumn[j], matrix[i][j]);
        }
    }
    // Step 2: Create the modified matrix
    const answer = matrix.map((row, i) => row.map((value, j) => (value === -1 ? maxInColumn[j] : value)));
    return answer;
}
;
const input = [[1, 2, -1], [4, -1, 6], [7, 8, 9]];
const results = modifiedMatrix(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
