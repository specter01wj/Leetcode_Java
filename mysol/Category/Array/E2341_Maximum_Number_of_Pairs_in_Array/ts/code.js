function numberOfPairs(nums) {
    var numCounts = {};
    nums.forEach(function (num) {
        numCounts[num] = (numCounts[num] || 0) + 1;
    });
    var pairs = 0;
    var leftovers = 0;
    Object.values(numCounts).forEach(function (count) {
        pairs += Math.floor(count / 2);
        leftovers += count % 2;
    });
    return [pairs, leftovers];
}
var input = [1, 3, 2, 1, 3, 2, 2];
var output = numberOfPairs(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
