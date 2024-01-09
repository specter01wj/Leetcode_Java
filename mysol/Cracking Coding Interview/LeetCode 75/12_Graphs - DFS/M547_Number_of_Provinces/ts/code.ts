function findCircleNum(isConnected: number[][]): number {
  let n: number = isConnected.length;
  let visited: boolean[] = new Array(n).fill(false);
  let count: number = 0;

  function dfs(city: number): void {
      for (let i = 0; i < n; i++) {
          if (isConnected[city][i] === 1 && !visited[i]) {
              visited[i] = true;
              dfs(i);
          }
      }
  }

  for (let i = 0; i < n; i++) {
      if (!visited[i]) {
          dfs(i);
          count++;
      }
  }

  return count;
};

let input1 = [[1,1,0],[1,1,0],[0,0,1]];
let output1 = findCircleNum(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

