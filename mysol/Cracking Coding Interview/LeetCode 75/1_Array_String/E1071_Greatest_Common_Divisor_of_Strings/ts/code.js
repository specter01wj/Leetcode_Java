function gcdOfStrings(str1, str2) {
    if ((str1 + str2) !== (str2 + str1)) {
        return "";
    }
    var gcdVal = gcd(str1.length, str2.length);
    return str2.substring(0, gcdVal);
}
function gcd(p, q) {
    if (q === 0) {
        return p;
    }
    else {
        return gcd(q, p % q);
    }
}
var str1 = "ABABAB", str2 = "ABAB";
var output1 = gcdOfStrings(str1, str2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
