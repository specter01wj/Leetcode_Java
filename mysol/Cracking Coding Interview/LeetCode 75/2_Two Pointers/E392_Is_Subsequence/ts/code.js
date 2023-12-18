function isSubsequence(s, t) {
    var i = 0, j = 0;
    while (i < s.length && j < t.length) {
        if (s.charCodeAt(i) === t.charCodeAt(j)) {
            i++;
        }
        j++;
    }
    return i === s.length;
}
;
var input1 = "abc", input2 = "ahbgdc";
var output1 = isSubsequence(input1, input2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
