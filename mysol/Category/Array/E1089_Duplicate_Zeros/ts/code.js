function duplicateZeros(arr) {
    let n = arr.length;
    let possibleDups = 0;
    let last = n - 1;
    // Count the number of zeros to be duplicated
    for (let i = 0; i <= last - possibleDups; i++) {
        if (arr[i] === 0) {
            // Edge case: zero at the boundary
            if (i === last - possibleDups) {
                arr[last] = 0;
                last--;
                break;
            }
            possibleDups++;
        }
    }
    // Start from the end and move elements accordingly
    for (let i = last - possibleDups; i >= 0; i--) {
        if (arr[i] === 0) {
            arr[i + possibleDups] = 0;
            possibleDups--;
            arr[i + possibleDups] = 0;
        }
        else {
            arr[i + possibleDups] = arr[i];
        }
    }
}
;
const input = [1, 0, 2, 3, 0, 4, 5, 0];
const inputCopy = [...input];
duplicateZeros(inputCopy);
const results = inputCopy;
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
