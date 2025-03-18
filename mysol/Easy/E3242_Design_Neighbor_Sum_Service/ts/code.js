class NeighborSum {
    /**
     * @param grid: a 2D array of numbers
     */
    constructor(grid) {
        this.grid = grid;
        this.n = grid.length;
        this.valueToPosition = new Map();
        // Store value positions in the map
        for (let i = 0; i < this.n; i++) {
            for (let j = 0; j < this.n; j++) {
                this.valueToPosition.set(grid[i][j], [i, j]);
            }
        }
    }
    /**
     * @param value: a number
     * @return: a number
     */
    adjacentSum(value) {
        if (!this.valueToPosition.has(value))
            return 0;
        const [i, j] = this.valueToPosition.get(value);
        let sum = 0;
        // Adjacent neighbors (top, bottom, left, right)
        const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
        for (const [di, dj] of directions) {
            const ni = i + di, nj = j + dj;
            if (ni >= 0 && ni < this.n && nj >= 0 && nj < this.n) {
                sum += this.grid[ni][nj];
            }
        }
        return sum;
    }
    /**
     * @param value: a number
     * @return: a number
     */
    diagonalSum(value) {
        if (!this.valueToPosition.has(value))
            return 0;
        const [i, j] = this.valueToPosition.get(value);
        let sum = 0;
        // Diagonal neighbors (top-left, top-right, bottom-left, bottom-right)
        const directions = [[-1, -1], [-1, 1], [1, -1], [1, 1]];
        for (const [di, dj] of directions) {
            const ni = i + di, nj = j + dj;
            if (ni >= 0 && ni < this.n && nj >= 0 && nj < this.n) {
                sum += this.grid[ni][nj];
            }
        }
        return sum;
    }
}
const grid = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8]
];
const results = new NeighborSum(grid);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = `
      <h2>Input Grid:</h2>
      <table border="1" cellpadding="5" cellspacing="0">
        ${grid.map(row => `<tr>${row.map(num => `<td>${num}</td>`).join('')}</tr>`).join('')}
      </table>

      <h2>Results:</h2>
      <table border="1" cellpadding="5" cellspacing="0">
        <tr><td>adjacentSum(1)</td><td>${results.adjacentSum(1)}</td></tr>
        <tr><td>adjacentSum(4)</td><td>${results.adjacentSum(4)}</td></tr>
        <tr><td>diagonalSum(4)</td><td>${results.diagonalSum(4)}</td></tr>
        <tr><td>diagonalSum(8)</td><td>${results.diagonalSum(8)}</td></tr>
      </table>
    `;
