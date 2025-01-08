function returnToBoundaryCount(nums) {
    // Variable to track the current position of the ant
    let position = 0;
    // Variable to count the number of times the ant returns to the boundary
    let boundaryCount = 0;
    // Iterate through the given array
    for (let num of nums) {
        // Update the position of the ant based on the current step
        position += num;
        // Check if the ant is back to the boundary
        if (position === 0) {
            boundaryCount++;
        }
    }
    // Return the total count
    return boundaryCount;
}
;
const input = [2, 3, -5];
const results = returnToBoundaryCount(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
