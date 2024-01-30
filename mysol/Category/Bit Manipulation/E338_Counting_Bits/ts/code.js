function countBits(n) {
    var ans = new Array(n + 1);
    for (var i = 0; i <= n; i++) {
        ans[i] = countOnes(i);
    }
    return ans;
}
;
function countOnes(num) {
    return num.toString(2).split('1').length - 1;
}
var input1 = 5;
var output1 = countBits(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
