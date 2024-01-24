function minCostClimbingStairs(cost: number[]): number {
  const n = cost.length;
  const minCost: number[] = new Array(n + 1);

  minCost[0] = 0;
  minCost[1] = 0;

  for (let i = 2; i <= n; i++) {
      minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
  }

  return minCost[n];
};

let input1 = [1,100,1,1,1,100,1,1,100,1];
let output1 = minCostClimbingStairs(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

