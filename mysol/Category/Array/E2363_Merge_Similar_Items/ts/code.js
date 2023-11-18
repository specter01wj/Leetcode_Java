var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
function mergeSimilarItems(items1, items2) {
    var map = {};
    var items = __spreadArray(__spreadArray([], items1, true), items2, true);
    // Sum weights for each unique value
    for (var _i = 0, items_1 = items; _i < items_1.length; _i++) {
        var _a = items_1[_i], val = _a[0], weight = _a[1];
        if (map[val]) {
            map[val] += weight;
        }
        else {
            map[val] = weight;
        }
    }
    // Convert the map to an array, sort it by value, and return
    return Object.entries(map).map(function (_a) {
        var value = _a[0], weight = _a[1];
        return [parseInt(value, 10), weight];
    })
        .sort(function (a, b) { return a[0] - b[0]; });
}
var input1 = [[1, 1], [4, 5], [3, 8]], input2 = [[3, 1], [1, 5]];
var output = mergeSimilarItems(input1, input2);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
