function findChampion(grid: number[][]): number {
  const n = grid.length;

  // Start with the assumption that team 0 is the champion
  let champion = 0;

  // Iterate through all teams to find a potential champion
  for (let i = 1; i < n; i++) {
      if (grid[champion][i] === 0) {
          // If the current champion loses to team i, update champion
          champion = i;
      }
  }

  // Verify if the identified champion is actually the champion
  for (let i = 0; i < n; i++) {
      if (i !== champion && (grid[champion][i] === 0 || grid[i][champion] === 1)) {
          // If the champion loses to or fails to beat another team, return -1
          return -1;
      }
  }

  return champion;
};

const input: number[][] = [[0,0,1],[1,0,1],[0,0,0]];
const results = findChampion(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

