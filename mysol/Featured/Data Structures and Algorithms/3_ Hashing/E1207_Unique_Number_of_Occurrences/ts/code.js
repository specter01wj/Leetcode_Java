function uniqueOccurrences(arr) {
    const countMap = new Map();
    // Count frequency of each number
    for (const num of arr) {
        countMap.set(num, (countMap.get(num) || 0) + 1);
    }
    const seen = new Set();
    for (const freq of countMap.values()) {
        if (seen.has(freq)) {
            return false;
        }
        seen.add(freq);
    }
    return true;
}
;
const input = [1, 2, 2, 1, 1, 3];
const results = uniqueOccurrences(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
