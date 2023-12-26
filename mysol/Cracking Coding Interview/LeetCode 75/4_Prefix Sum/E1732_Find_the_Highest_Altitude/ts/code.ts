function largestAltitude(gain: number[]): number {
  let maxAlt = 0;
  let currAlt = 0;

  for (let i = 0; i < gain.length; i++) {
      currAlt += gain[i];
      maxAlt = Math.max(currAlt, maxAlt);
  }

  return maxAlt;
};

let input1 = [-5,1,5,0,-7];
let output1 = largestAltitude(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

