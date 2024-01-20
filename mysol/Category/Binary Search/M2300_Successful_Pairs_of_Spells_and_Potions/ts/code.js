function successfulPairs(spells, potions, success) {
    // Sort the potions array
    potions.sort(function (a, b) { return a - b; });
    var n = spells.length;
    var pairs = new Array(n).fill(0);
    for (var i = 0; i < n; i++) {
        var left = 0;
        var right = potions.length - 1;
        // Apply binary search for each spell
        while (left <= right) {
            var mid = Math.floor((left + right) / 2);
            if (spells[i] * potions[mid] < success) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        // Count the number of successful pairs for the current spell
        pairs[i] = potions.length - left;
    }
    return pairs;
}
;
var spells = [5, 1, 3], potions = [1, 2, 3, 4, 5], success = 7;
var output1 = successfulPairs(spells, potions, success);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
