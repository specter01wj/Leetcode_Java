
function stringShift(s: string, shift: number[][]): string {
  let totalShift = 0;

  // Calculate the net shift amount
  for (let i = 0; i < shift.length; i++) {
      const direction = shift[i][0];
      const amount = shift[i][1];

      // Left shift
      if (direction === 0) {
          totalShift -= amount;
      }
      // Right shift
      else {
          totalShift += amount;
      }
  }

  // Reduce totalShift to a value within the string length
  const len = s.length;
  totalShift %= len;

  // Handle negative shifts by converting them to positive shifts
  if (totalShift < 0) {
      totalShift += len;
  }

  // Perform the final shift
  return s.slice(-totalShift) + s.slice(0, -totalShift);
};

const input: string = "abc";
const shift: number[][] = [[0,1],[1,2]];
const results = stringShift(input, shift);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

