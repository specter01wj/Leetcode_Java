function orangesRotting(grid: number[][]): number {
  if (!grid || grid.length === 0) return -1;

  let freshCount = 0;
  let queue: [number, number][] = [];
  const m = grid.length, n = grid[0].length;

  // Initialize with all rotten oranges and count fresh oranges
  for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
          if (grid[i][j] === 2) {
              queue.push([i, j]);
          } else if (grid[i][j] === 1) {
              freshCount++;
          }
      }
  }

  if (freshCount === 0) return 0; // No fresh oranges initially

  let minutes = 0;
  const directions: [number, number][] = [[-1, 0], [1, 0], [0, -1], [0, 1]]; // 4-directional

  while (queue.length > 0 && freshCount > 0) {
      let size = queue.length;
      for (let i = 0; i < size; i++) {
          let [x, y] = queue.shift()!;
          for (let [dx, dy] of directions) {
              let newX = x + dx, newY = y + dy;
              if (newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] !== 1) {
                  continue;
              }
              grid[newX][newY] = 2; // Rot the fresh orange
              queue.push([newX, newY]);
              freshCount--;
          }
      }
      minutes++;
  }

  return freshCount === 0 ? minutes : -1;
};

let input1 = [[2,1,1],[1,1,0],[0,1,1]];
let output1 = orangesRotting(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

