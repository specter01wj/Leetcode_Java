function closeStrings(word1, word2) {
    if (word1.length !== word2.length)
        return false;
    const freq1 = new Map();
    const freq2 = new Map();
    for (const ch of word1) {
        freq1.set(ch, (freq1.get(ch) || 0) + 1);
    }
    for (const ch of word2) {
        freq2.set(ch, (freq2.get(ch) || 0) + 1);
    }
    const keys1 = Array.from(freq1.keys()).sort().join('');
    const keys2 = Array.from(freq2.keys()).sort().join('');
    if (keys1 !== keys2)
        return false;
    const values1 = Array.from(freq1.values()).sort((a, b) => a - b);
    const values2 = Array.from(freq2.values()).sort((a, b) => a - b);
    return JSON.stringify(values1) === JSON.stringify(values2);
}
;
const input = "cabbba", word2 = "abbccc";
const results = closeStrings(input, word2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
