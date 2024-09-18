function similarPairs(words) {
    var _a;
    const map = new Map();
    for (const word of words) {
        let signature = 0;
        for (const c of word) {
            const bit = c.charCodeAt(0) - 'a'.charCodeAt(0);
            signature |= 1 << bit;
        }
        map.set(signature, ((_a = map.get(signature)) !== null && _a !== void 0 ? _a : 0) + 1);
    }
    let count = 0;
    for (const freq of map.values()) {
        if (freq >= 2) {
            count += (freq * (freq - 1)) / 2;
        }
    }
    return count;
}
;
const input = ["aba", "aabb", "abcd", "bac", "aabc"];
const results = similarPairs(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
