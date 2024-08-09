function largestUniqueNumber(nums) {
    // Step 1: Count the frequency of each number using a Map
    const frequencyMap = new Map();
    for (const num of nums) {
        frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1);
    }
    // Step 2: Find the largest number that occurs only once
    let largestUnique = -1;
    for (const [num, count] of frequencyMap) {
        if (count === 1) {
            largestUnique = Math.max(largestUnique, num);
        }
    }
    return largestUnique;
}
;
const input = [5, 7, 3, 9, 4, 9, 8, 3, 1];
const results = largestUniqueNumber(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
