
function canAttendMeetings(intervals: number[][]): boolean {
  // Sort the intervals by start time
  intervals.sort((a, b) => a[0] - b[0]);
    
  // Check for any overlapping intervals
  for (let i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < intervals[i - 1][1]) {
          return false; // Found overlapping intervals
      }
  }
  
  return true; // No overlapping intervals found
}

let nums: number[][] = [[7, 10], [2, 4]];
let output = canAttendMeetings(nums);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();

