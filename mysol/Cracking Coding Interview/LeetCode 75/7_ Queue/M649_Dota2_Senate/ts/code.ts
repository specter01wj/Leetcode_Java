function predictPartyVictory(senate: string): string {
  let radiant: number[] = [];
  let dire: number[] = [];

  // Initialize the queues with the indices of the senators
  for (let i = 0; i < senate.length; i++) {
      if (senate[i] === 'R') {
          radiant.push(i);
      } else {
          dire.push(i);
      }
  }

  while (radiant.length > 0 && dire.length > 0) {
      let radiantIndex = radiant.shift();
      let direIndex = dire.shift();

      // The senator with the smaller index gets to act first
      if (radiantIndex < direIndex) {
          radiant.push(radiantIndex + senate.length);
      } else {
          dire.push(direIndex + senate.length);
      }
  }

  return radiant.length === 0 ? "Dire" : "Radiant";
};

let input1 = "RDD";
let output1 = predictPartyVictory(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

