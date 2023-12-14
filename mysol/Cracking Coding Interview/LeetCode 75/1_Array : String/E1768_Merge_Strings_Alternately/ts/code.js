function mergeAlternately(word1, word2) {
    var n = word1.length, m = word2.length, i = 0, j = 0;
    var res = '';
    while (i < n || j < m) {
        if (i < n) {
            res += word1[i++];
        }
        if (j < m) {
            res += word2[j++];
        }
    }
    return res;
}
var word1 = "abcd", word2 = "pq";
var output1 = mergeAlternately(word1, word2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
