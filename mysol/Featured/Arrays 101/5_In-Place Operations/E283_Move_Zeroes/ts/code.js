function moveZeroes(nums) {
    let insertPos = 0;
    // Move all non-zero elements to the front
    for (let num of nums) {
        if (num !== 0) {
            nums[insertPos++] = num;
        }
    }
    // Fill the remaining positions with zeroes
    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
;
const input = [0, 1, 0, 3, 12];
const inputCopy = [...input];
moveZeroes(inputCopy);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(inputCopy, null, 2);
