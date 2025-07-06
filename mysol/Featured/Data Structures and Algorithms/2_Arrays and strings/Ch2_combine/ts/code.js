function combine(arr1, arr2) {
    const ans = [];
    let i = 0, j = 0;
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            ans.push(arr1[i]);
            i++;
        }
        else {
            ans.push(arr2[j]);
            j++;
        }
    }
    while (i < arr1.length) {
        ans.push(arr1[i]);
        i++;
    }
    while (j < arr2.length) {
        ans.push(arr2[j]);
        j++;
    }
    return ans;
}
const input1 = [1, 4, 7, 20];
const input2 = [3, 5, 6];
const results = combine(input1, input2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + JSON.stringify(input1, null, 2) + '; Input2: ' + JSON.stringify(input2, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
