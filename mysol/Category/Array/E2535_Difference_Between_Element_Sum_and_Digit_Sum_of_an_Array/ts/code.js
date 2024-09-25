function differenceOfSum(nums) {
    let elementSum = 0;
    let digitSum = 0;
    // Calculate element sum and digit sum
    for (let num of nums) {
        elementSum += num;
        // Calculate the digit sum of the current number
        let currentNum = num;
        while (currentNum > 0) {
            digitSum += currentNum % 10;
            currentNum = Math.floor(currentNum / 10);
        }
    }
    // Return the absolute difference between element sum and digit sum
    return Math.abs(elementSum - digitSum);
}
;
const input = [1, 15, 6, 3];
const results = differenceOfSum(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
