type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function chunk(arr: Obj[], size: number): Obj[][] {
	let chunkedArr: Obj[][] = [];

    for (let i = 0; i < arr.length; i += size) {
        chunkedArr.push(arr.slice(i, i + size) as Obj[]);
    }

    return chunkedArr;
};


let inpu1 = [1,9,6,3,2], size = 3;
let output1 = chunk(input1, size);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();


