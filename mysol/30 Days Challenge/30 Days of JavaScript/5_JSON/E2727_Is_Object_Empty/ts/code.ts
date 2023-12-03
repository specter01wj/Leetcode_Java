
type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | JSONValue[]

function isEmpty(obj: Obj): boolean {
	return Object.keys(obj).length === 0;
};


let input1 = {"x": 5, "y": 42}, input2 = {};
let output1 = isEmpty(input1);
let output2 = isEmpty(input2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();



