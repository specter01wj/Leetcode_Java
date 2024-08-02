function sumOfDigits(nums) {
    // Step 1: Find the minimum element in the array
    let minElement = Math.min(...nums);
    // Step 2: Calculate the sum of the digits of the minimum element
    let sumOfDigits = 0;
    while (minElement > 0) {
        sumOfDigits += minElement % 10;
        minElement = Math.floor(minElement / 10);
    }
    // Step 3: Check if the sum of the digits is odd or even
    return sumOfDigits % 2 === 0 ? 1 : 0;
}
;
const nums = [34, 23, 1, 24, 75, 33, 54, 8];
const results = sumOfDigits(nums);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + nums + '<br>Result = ' + results;
