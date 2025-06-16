function validMountainArray(arr) {
    const n = arr.length;
    if (n < 3)
        return false;
    let i = 0;
    // walk up
    while (i + 1 < n && arr[i] < arr[i + 1]) {
        i++;
    }
    // peak can't be first or last
    if (i === 0 || i === n - 1)
        return false;
    // walk down
    while (i + 1 < n && arr[i] > arr[i + 1]) {
        i++;
    }
    return i === n - 1;
}
;
const input = [0, 3, 2, 1];
const results = validMountainArray(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
