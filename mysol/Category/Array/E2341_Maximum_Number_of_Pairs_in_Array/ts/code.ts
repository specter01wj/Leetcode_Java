
function numberOfPairs(nums: number[]): [number, number] {
  let numCounts: Record<number, number> = {};
  nums.forEach(num => {
      numCounts[num] = (numCounts[num] || 0) + 1;
  });
  
  let pairs: number = 0;
  let leftovers: number = 0;
  Object.values(numCounts).forEach(count => {
      pairs += Math.floor(count / 2);
      leftovers += count % 2;
  });
  
  return [pairs, leftovers];
}

let input: number[] = [1,3,2,1,3,2,2];
let output = numberOfPairs(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


