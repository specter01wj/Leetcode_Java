function fillCups(amount) {
    var max = 0, sum = 0;
    for (var _i = 0, amount_1 = amount; _i < amount_1.length; _i++) {
        var i = amount_1[_i];
        max = Math.max(i, max);
        sum += i;
    }
    return Math.max(max, Math.floor((sum + 1) / 2));
}
var input = [1, 4, 2];
var output = fillCups(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
