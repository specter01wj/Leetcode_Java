function areOccurrencesEqual(s) {
    const counts = new Map();
    for (const char of s) {
        counts.set(char, (counts.get(char) || 0) + 1);
    }
    const frequencies = new Set(counts.values());
    return frequencies.size === 1;
}
;
const input = "abacbc";
const results = areOccurrencesEqual(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
