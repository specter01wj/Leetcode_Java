function minReorder(n: number, connections: number[][]): number {
  const al: number[][] = Array.from({ length: n }, () => []);
  for (let c of connections) {
      al[c[0]].push(c[1]);
      al[c[1]].push(-c[0]); // Negative to indicate reverse direction
  }

  const visited: boolean[] = new Array(n).fill(false);

  const dfs = (from: number): number => {
      let change = 0;
      visited[from] = true;
      for (let to of al[from]) {
          if (!visited[Math.abs(to)]) {
              change += dfs(Math.abs(to)) + (to > 0 ? 1 : 0);
          }
      }
      return change;
  };

  return dfs(0);
};

let input1 = [[0,1],[1,3],[2,3],[4,0],[4,5]];
let n = 6;
let output1 = minReorder(n, input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

