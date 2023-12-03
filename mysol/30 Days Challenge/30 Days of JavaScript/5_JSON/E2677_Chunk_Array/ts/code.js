function chunk(arr, size) {
    var chunkedArr = [];
    for (var i = 0; i < arr.length; i += size) {
        chunkedArr.push(arr.slice(i, i + size));
    }
    return chunkedArr;
}
;
var input1 = [1, 9, 6, 3, 2], size = 3;
var output1 = chunk(input1, size);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
