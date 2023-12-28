var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
function closeStrings(word1, word2) {
    if (word1.length !== word2.length) {
        return false;
    }
    var freq1 = new Array(26).fill(0);
    var freq2 = new Array(26).fill(0);
    var present1 = new Set();
    var present2 = new Set();
    for (var _i = 0, word1_1 = word1; _i < word1_1.length; _i++) {
        var char = word1_1[_i];
        var index = char.charCodeAt(0) - 'a'.charCodeAt(0);
        freq1[index]++;
        present1.add(char);
    }
    for (var _a = 0, word2_1 = word2; _a < word2_1.length; _a++) {
        var char = word2_1[_a];
        var index = char.charCodeAt(0) - 'a'.charCodeAt(0);
        freq2[index]++;
        present2.add(char);
    }
    if (present1.size !== present2.size || !__spreadArray([], present1, true).every(function (char) { return present2.has(char); })) {
        return false;
    }
    freq1.sort(function (a, b) { return a - b; });
    freq2.sort(function (a, b) { return a - b; });
    return freq1.every(function (val, index) { return val === freq2[index]; });
}
;
var word1 = "abc", word2 = "bca";
var output1 = closeStrings(word1, word2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
