function isSubsequence(s, t) {
    let i = 0;
    let j = 0;
    while (i < s.length && j < t.length) {
        if (s[i] === t[j]) {
            i++;
        }
        j++;
    }
    return i === s.length;
}
const input1 = "ace", input2 = "abcde";
const results = isSubsequence(input1, input2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input1, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
