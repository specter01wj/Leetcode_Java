function reduce(nums, fn) {
    var val = init;
    for (var i = 0; i < nums.length; i++) {
        val = fn(val, nums[i]);
    }
    return val;
}
function fn(a, b) {
    return a + b;
}
var input = [1, 2, 3, 4], init = 10;
var output1 = reduce(input, fn, init);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
