function customSortString(order, s) {
    const freq = new Map();
    // Count frequency of each character in s
    for (const ch of s) {
        freq.set(ch, (freq.get(ch) || 0) + 1);
    }
    let result = '';
    // Add characters in the order defined by 'order'
    for (const ch of order) {
        if (freq.has(ch)) {
            result += ch.repeat(freq.get(ch));
            freq.delete(ch);
        }
    }
    // Add remaining characters not in 'order'
    for (const [ch, count] of freq.entries()) {
        result += ch.repeat(count);
    }
    return result;
}
;
const input = "cba", s = "abcd";
const results = customSortString(input, s);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
