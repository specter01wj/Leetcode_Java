function totalCost(costs: number[], k: number, candidates: number): number {
  let headWorkers: number[] = [];
  let tailWorkers: number[] = [];

  // Initialize the queues
  for (let i = 0; i < candidates; i++) {
      headWorkers.push(costs[i]);
  }
  for (let i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
      tailWorkers.push(costs[i]);
  }

  headWorkers.sort((a, b) => a - b);
  tailWorkers.sort((a, b) => a - b);

  let answer: number = 0;
  let nextHead: number = candidates;
  let nextTail: number = costs.length - 1 - candidates;

  for (let i = 0; i < k; i++) {
      if (tailWorkers.length === 0 || (headWorkers.length > 0 && headWorkers[0] <= tailWorkers[0])) {
          answer += headWorkers.shift()!;
          if (nextHead <= nextTail) {
              insertSorted(headWorkers, costs[nextHead]);
              nextHead++;
          }
      } else {
          answer += tailWorkers.shift()!;
          if (nextHead <= nextTail) {
              insertSorted(tailWorkers, costs[nextTail]);
              nextTail--;
          }
      }
  }

  return answer;
};

function insertSorted(arr: number[], value: number): void {
  const index = arr.findIndex(x => x > value);
  if (index === -1) {
      arr.push(value);
  } else {
      arr.splice(index, 0, value);
  }
}

let input1 = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4;
let output1 = totalCost(input1, k, candidates);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

