function frequencySort(s) {
    const freqMap = new Map();
    // Count character frequencies
    for (const char of s) {
        freqMap.set(char, (freqMap.get(char) || 0) + 1);
    }
    // Sort characters by frequency descending
    const sorted = [...freqMap.entries()].sort((a, b) => b[1] - a[1]);
    // Build result string
    let result = '';
    for (const [char, freq] of sorted) {
        result += char.repeat(freq);
    }
    return result;
}
;
const input = "tree";
const results = frequencySort(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
