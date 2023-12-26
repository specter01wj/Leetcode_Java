function largestAltitude(gain) {
    var maxAlt = 0;
    var currAlt = 0;
    for (var i = 0; i < gain.length; i++) {
        currAlt += gain[i];
        maxAlt = Math.max(currAlt, maxAlt);
    }
    return maxAlt;
}
;
var input1 = [-5, 1, 5, 0, -7];
var output1 = largestAltitude(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
