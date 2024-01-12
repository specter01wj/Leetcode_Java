function nearestExit(maze: string[][], entrance: number[]): number {
  const m = maze.length, n = maze[0].length;
  const queue: [number, number, number][] = [[entrance[0], entrance[1], 0]];
  maze[entrance[0]][entrance[1]] = '+'; // Mark the entrance as visited

  while (queue.length > 0) {
      const [x, y, dist] = queue.shift()!; // Use non-null assertion since queue is never empty here

      const directions: [number, number][] = [[-1, 0], [1, 0], [0, -1], [0, 1]]; // Up, Down, Left, Right

      for (const [dx, dy] of directions) {
          const newX = x + dx, newY = y + dy;

          if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] === '.') {
              if (newX === 0 || newX === m - 1 || newY === 0 || newY === n - 1) {
                  return dist + 1; // Found an exit
              }
              maze[newX][newY] = '+'; // Mark as visited
              queue.push([newX, newY, dist + 1]);
          }
      }
  }
  return -1; // No exit found
};

let input1 = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]];
let entrance = [1,2];
let output1 = nearestExit(input1, entrance);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

