function sumOfUnique(nums) {
    const countMap = new Map();
    // Count occurrences
    for (const num of nums) {
        countMap.set(num, (countMap.get(num) || 0) + 1);
    }
    let sum = 0;
    for (const [key, value] of countMap.entries()) {
        if (value === 1) {
            sum += key;
        }
    }
    return sum;
}
;
const input = [1, 2, 3, 2];
const results = sumOfUnique(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
