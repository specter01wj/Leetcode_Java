type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (arr:  MultiDimensionalArray, n: number):  MultiDimensionalArray {
    if (n === 0) {
        return arr;
    }
    
    const result: MultiDimensionalArray = [];
    arr.forEach(item => {
        if (typeof item === 'number') {
            result.push(item);
        } else {
            result.push(...flat(item, n - 1));
        }
    })

    return result;
};


let input1 = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]];
let n1 = 0, n2 = 1, n3 = 2;

let output1 = flat(input1, n1);
let output2 = flat(input1, n2);
let output3 = flat(input1, n3);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);



