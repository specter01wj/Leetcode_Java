function tribonacci(n) {
    if (n === 0)
        return 0;
    if (n === 1 || n === 2)
        return 1;
    var trib = [0, 1, 1];
    for (var i = 3; i <= n; i++) {
        trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
    }
    return trib[n];
}
;
var input1 = 4;
var output1 = tribonacci(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
