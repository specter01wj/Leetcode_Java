function findPeaks(mountain) {
    const peaks = [];
    // Start from the second element and go up to the second last element
    for (let i = 1; i < mountain.length - 1; i++) {
        // Check if the current element is strictly greater than its neighbors
        if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
            peaks.push(i); // Add the index to the list of peaks
        }
    }
    return peaks;
}
;
const input = [1, 4, 3, 8, 5];
const results = findPeaks(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
