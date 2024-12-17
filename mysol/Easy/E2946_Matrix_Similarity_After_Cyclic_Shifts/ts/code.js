function areSimilar(mat, k) {
    const m = mat.length; // Number of rows
    const n = mat[0].length; // Number of columns
    // Normalize k to avoid unnecessary full cycles
    k = k % n;
    for (let i = 0; i < m; i++) {
        if (i % 2 === 0) {
            // Even-indexed rows: Shift left
            if (!isShiftedLeft(mat[i], k, n)) {
                return false;
            }
        }
        else {
            // Odd-indexed rows: Shift right
            if (!isShiftedRight(mat[i], k, n)) {
                return false;
            }
        }
    }
    return true;
}
;
function isShiftedLeft(row, k, n) {
    for (let j = 0; j < n; j++) {
        if (row[j] !== row[(j + k) % n]) {
            return false;
        }
    }
    return true;
}
function isShiftedRight(row, k, n) {
    for (let j = 0; j < n; j++) {
        if (row[j] !== row[(j - k + n) % n]) {
            return false;
        }
    }
    return true;
}
const input = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
const k = 4;
const results = areSimilar(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
