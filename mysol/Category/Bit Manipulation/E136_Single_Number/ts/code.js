function singleNumber(nums) {
    var single = 0;
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        single ^= num;
    }
    return single;
}
;
var input1 = [4, 1, 2, 1, 2];
var output1 = singleNumber(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
