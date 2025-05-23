function findMaxConsecutiveOnes(nums) {
    let maxCount = 0;
    let currentCount = 0;
    for (const num of nums) {
        if (num === 1) {
            currentCount++;
            maxCount = Math.max(maxCount, currentCount);
        }
        else {
            currentCount = 0;
        }
    }
    return maxCount;
}
;
const input = [1, 1, 0, 1, 1, 1];
const results = findMaxConsecutiveOnes(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
