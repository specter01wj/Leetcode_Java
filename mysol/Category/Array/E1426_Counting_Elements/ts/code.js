function countElements(arr) {
    // Create a Set to store the unique elements from the array
    const elementsSet = new Set(arr);
    let count = 0;
    // Loop through the array and check if num + 1 exists in the set
    for (let num of arr) {
        if (elementsSet.has(num + 1)) {
            count++;
        }
    }
    return count;
}
;
const input = [1, 2, 3];
const results = countElements(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
