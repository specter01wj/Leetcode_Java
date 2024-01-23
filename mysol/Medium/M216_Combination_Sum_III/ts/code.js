var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
function combinationSum3(k, n) {
    var result = [];
    backtrack(result, [], k, n, 1);
    return result;
}
;
function backtrack(result, current, k, remain, start) {
    if (remain === 0 && current.length === k) {
        result.push(__spreadArray([], current, true));
        return;
    }
    for (var i = start; i <= 9; i++) {
        if (remain - i < 0 || current.length >= k) {
            break;
        }
        current.push(i);
        backtrack(result, current, k, remain - i, i + 1);
        current.pop();
    }
}
var k = 3, n = 7;
var output1 = combinationSum3(k, n);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
