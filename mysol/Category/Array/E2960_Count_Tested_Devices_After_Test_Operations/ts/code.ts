function countTestedDevices(batteryPercentages: number[]): number {
  let testedDevices = 0;

  for (let i = 0; i < batteryPercentages.length; i++) {
      // Check if the current device can be tested
      if (batteryPercentages[i] > 0) {
          testedDevices++;
          // Decrease the battery percentage for devices in range [i + 1, n - 1]
          for (let j = i + 1; j < batteryPercentages.length; j++) {
              batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
          }
      }
  }

  return testedDevices;
};

const input: number[] = [1,1,2,1,3];
const inputCopy: number[] = [...input];
const results = countTestedDevices(inputCopy);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

