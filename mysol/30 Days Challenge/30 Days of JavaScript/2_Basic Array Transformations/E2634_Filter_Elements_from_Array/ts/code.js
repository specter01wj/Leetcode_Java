function filter(arr, fn) {
    var filteredArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) {
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
function fn(number, index) {
    return number % index === 0;
}
var input = [0, 1, 2, 4, 6, 10];
var output1 = filter(input, fn);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
