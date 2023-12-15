function kidsWithCandies(candies: number[], extraCandies: number): boolean[] {
  const ans: boolean[] = [];
  const max: number = Math.max(...candies);

  for (let candy of candies) {
      ans.push(candy + extraCandies >= max);
  }

  return ans;
};

let input = [2,3,5,1,3], extraCandies = 3;
let output1 = kidsWithCandies(input, extraCandies);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

