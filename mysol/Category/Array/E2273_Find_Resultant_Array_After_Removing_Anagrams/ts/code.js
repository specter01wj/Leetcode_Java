function removeAnagrams(words) {
    var i = 1; // start from the second word
    while (i < words.length) {
        if (areAnagrams(words[i], words[i - 1])) {
            // remove word at position i
            words.splice(i, 1);
        }
        else {
            i++;
        }
    }
    return words;
}
function areAnagrams(s1, s2) {
    return sortString(s1) === sortString(s2);
}
function sortString(str) {
    return str.split('').sort().join('');
}
var input = ["abba", "baba", "bbaa", "cd", "cd"];
var output = removeAnagrams(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
