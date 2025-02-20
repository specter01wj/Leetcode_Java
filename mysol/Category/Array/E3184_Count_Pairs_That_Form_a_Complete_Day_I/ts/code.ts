function countCompleteDayPairs(hours: number[]): number {
  let remainderCount: Map<number, number> = new Map();
  let count: number = 0;

  for (let hour of hours) {
      let remainder: number = hour % 24;
      let complement: number = (24 - remainder) % 24;
      
      count += remainderCount.get(complement) || 0;
      remainderCount.set(remainder, (remainderCount.get(remainder) || 0) + 1);
  }

  return count;
};

const input: number[] = [12,12,30,24,24];
const results = countCompleteDayPairs(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

