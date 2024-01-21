function minEatingSpeed(piles: number[], h: number): number {
  let left = 1; // minimum possible speed
  let right = Math.max(...piles); // maximum possible speed

  while (left < right) {
      let mid = Math.floor((left + right) / 2);
      if (canEatAll(piles, mid, h)) {
          // If she can eat all bananas at this rate, try a smaller speed
          right = mid;
      } else {
          // Otherwise, she needs a higher speed
          left = mid + 1;
      }
  }
  
  return left;
};

function canEatAll(piles: number[], speed: number, h: number): boolean {
  let hours = 0;
  for (let pile of piles) {
      hours += Math.ceil(pile / speed);
  }
  return hours <= h;
}

let input1 = [30,11,23,4,20], h = 5;
let output1 = minEatingSpeed(input1, h);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

