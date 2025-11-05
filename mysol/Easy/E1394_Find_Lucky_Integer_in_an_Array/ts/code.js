function findLucky(arr) {
    const freqMap = new Map();
    for (const num of arr) {
        freqMap.set(num, (freqMap.get(num) || 0) + 1);
    }
    let result = -1;
    for (const [num, freq] of freqMap.entries()) {
        if (num === freq) {
            result = Math.max(result, num);
        }
    }
    return result;
}
;
const input = [1, 2, 2, 3, 3, 3];
const results = findLucky(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
