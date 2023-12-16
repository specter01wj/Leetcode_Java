function reverseWords(s) {
    s = s.trim();
    var words = s.split(/\s+/).reverse();
    return words.join(' ');
}
;
var input1 = "the sky is blue";
var output1 = reverseWords(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
