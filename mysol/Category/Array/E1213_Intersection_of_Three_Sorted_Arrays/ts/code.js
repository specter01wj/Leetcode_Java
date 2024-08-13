function arraysIntersection(arr1, arr2, arr3) {
    let result = [];
    let i = 0, j = 0, k = 0;
    // Use three pointers to traverse the arrays
    while (i < arr1.length && j < arr2.length && k < arr3.length) {
        if (arr1[i] === arr2[j] && arr1[i] === arr3[k]) {
            // If all three elements are equal, add to result
            result.push(arr1[i]);
            i++;
            j++;
            k++;
        }
        else if (arr1[i] < arr2[j]) {
            i++;
        }
        else if (arr2[j] < arr3[k]) {
            j++;
        }
        else {
            k++;
        }
    }
    return result;
}
;
const arr1 = [1, 2, 3, 4, 5];
const arr2 = [1, 2, 5, 7, 9];
const arr3 = [1, 3, 4, 5, 8];
const results = arraysIntersection(arr1, arr2, arr3);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + arr1 + '; Input2: ' + arr2 + '; Input3: ' +
    arr3 + '<br>Result = ' + results;
