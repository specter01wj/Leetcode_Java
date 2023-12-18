type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Fn = (value: JSONValue) => number

function sortBy(arr: JSONValue[], fn: Fn): JSONValue[] {
	return arr.slice().sort((a, b) => {
    const aValue = fn(a);
    const bValue = fn(b);
    return aValue - bValue;
  });
};


let input1 = [5, 4, 1, 2, 3];
let input2 = [{"x": 1}, {"x": 0}, {"x": -1}];
let fn1 = (x) => x;
let fn2 = (d) => d.x;

let output1 = sortBy(input1, fn1);
let output2 = sortBy(input2, fn2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);



