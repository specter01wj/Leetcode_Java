class NeighborSum {
  private grid: number[][];
  private n: number;
  private valueToPosition: Map<number, [number, number]>;

  /**
   * @param grid: a 2D array of numbers
   */
  constructor(grid: number[][]) {
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
  adjacentSum(value: number): number {
      if (!this.valueToPosition.has(value)) return 0;
      const [i, j] = this.valueToPosition.get(value)!;
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
  diagonalSum(value: number): number {
      if (!this.valueToPosition.has(value)) return 0;
      const [i, j] = this.valueToPosition.get(value)!;
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
      <pre>${JSON.stringify(grid, null, 2)}</pre>
      <h3>adjacentSum(1) = ${results.adjacentSum(1)}</h3>
      <h3>adjacentSum(4) = ${results.adjacentSum(4)}</h3>
      <h3>diagonalSum(4) = ${results.diagonalSum(4)}</h3>
      <h3>diagonalSum(8) = ${results.diagonalSum(8)}</h3>
    `;
