function uniqueOccurrences(arr) {
    var count = {};
    for (var _i = 0, arr_1 = arr; _i < arr_1.length; _i++) {
        var a = arr_1[_i];
        count[a] = 1 + (count[a] || 0);
    }
    return Object.keys(count).length === new Set(Object.values(count)).size;
}
;
var input1 = [1, 2, 2, 1, 1, 3];
var output1 = uniqueOccurrences(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
