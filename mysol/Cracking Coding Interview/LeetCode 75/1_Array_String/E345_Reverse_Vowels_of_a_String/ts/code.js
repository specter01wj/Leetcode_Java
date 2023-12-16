function reverseVowels(s) {
    var _a;
    if (s === null || s.length === 0) {
        return s;
    }
    var vowels = "aeiouAEIOU";
    var chars = s.split("");
    var start = 0, end = s.length - 1;
    while (start < end) {
        while (start < end && !vowels.includes(chars[start])) {
            start++;
        }
        while (start < end && !vowels.includes(chars[end])) {
            end--;
        }
        _a = [chars[end], chars[start]], chars[start] = _a[0], chars[end] = _a[1]; // Swapping
        start++;
        end--;
    }
    return chars.join("");
}
;
var input1 = "leetcode";
var output1 = reverseVowels(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
