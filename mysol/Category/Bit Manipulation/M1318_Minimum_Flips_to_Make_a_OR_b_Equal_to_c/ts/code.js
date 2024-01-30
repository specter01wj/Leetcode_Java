function minFlips(a, b, c) {
    var flips = 0;
    while (a > 0 || b > 0 || c > 0) {
        var lastBitA = a & 1;
        var lastBitB = b & 1;
        var lastBitC = c & 1;
        // Check if the current bits of a and b do not match the bit in c
        if ((lastBitA | lastBitB) !== lastBitC) {
            flips += (lastBitC === 0) ? (lastBitA + lastBitB) : 1;
        }
        // Move to the next set of bits
        a >>= 1;
        b >>= 1;
        c >>= 1;
    }
    return flips;
}
;
var a = 2, b = 6, c = 5;
var output1 = minFlips(a, b, c);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
