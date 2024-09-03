
function hardestWorker(n: number, logs: number[][]): number {
  let maxDuration = 0;
  let employeeId = Number.MAX_VALUE;
  let previousEndTime = 0;

  for (let i = 0; i < logs.length; i++) {
      const id = logs[i][0];
      const leaveTime = logs[i][1];
      const duration = leaveTime - previousEndTime;

      if (duration > maxDuration) {
          maxDuration = duration;
          employeeId = id;
      } else if (duration === maxDuration && id < employeeId) {
          employeeId = id;
      }

      previousEndTime = leaveTime;
  }

  return employeeId;
};

const input: number[][] = [[0, 3], [2, 5], [0, 9], [1, 15]];
const n: number = 10;
const results = hardestWorker(n, input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

