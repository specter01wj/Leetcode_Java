function canConstruct(ransomNote, magazine) {
    const freq = new Map();
    for (const char of magazine) {
        freq.set(char, (freq.get(char) || 0) + 1);
    }
    for (const char of ransomNote) {
        if (!freq.has(char) || freq.get(char) === 0) {
            return false;
        }
        freq.set(char, freq.get(char) - 1);
    }
    return true;
}
;
const input = "aa";
const magazine = "aab";
const results = canConstruct(input, magazine);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
