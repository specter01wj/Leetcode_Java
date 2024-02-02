function eraseOverlapIntervals(intervals) {
    // If there are no intervals, return 0
    if (intervals.length === 0)
        return 0;
    // Sort intervals by their end time
    intervals.sort(function (a, b) { return a[1] - b[1]; });
    var count = 0; // To keep track of intervals to remove
    var end = intervals[0][1]; // Initialize end to the end time of the first interval
    // Start from the second interval
    for (var i = 1; i < intervals.length; i++) {
        // If the start time of the current interval is less than the end time of the previous interval,
        // it means they overlap, so we need to remove an interval.
        if (intervals[i][0] < end) {
            count++;
        }
        else {
            // If they don't overlap, update the end to the end time of the current interval
            end = intervals[i][1];
        }
    }
    return count;
}
;
var input1 = [[1, 2], [2, 3], [3, 4], [1, 3]];
var output1 = eraseOverlapIntervals(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
