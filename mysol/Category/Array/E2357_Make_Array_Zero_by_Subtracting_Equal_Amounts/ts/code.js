function minimumOperations(nums) {
    var set = new Set();
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        if (num > 0) {
            set.add(num);
        }
    }
    return set.size;
}
var input = [1, 5, 0, 3, 5];
var output = minimumOperations(input);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
