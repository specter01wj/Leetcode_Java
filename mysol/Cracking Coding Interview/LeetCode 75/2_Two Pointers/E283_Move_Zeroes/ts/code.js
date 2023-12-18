function moveZeroes(nums) {
    // Initialize a pointer for the next position to place a non-zero number
    var insertPos = 0;
    var res = JSON.parse(JSON.stringify(nums));
    // Traverse the array, moving non-zero numbers to the front
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        if (num !== 0) {
            res[insertPos++] = num;
        }
    }
    // Fill the remaining array with zeroes
    while (insertPos < nums.length) {
        res[insertPos++] = 0;
    }
    return res;
}
;
var input1 = [0, 1, 0, 3, 12];
var output1 = moveZeroes(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
