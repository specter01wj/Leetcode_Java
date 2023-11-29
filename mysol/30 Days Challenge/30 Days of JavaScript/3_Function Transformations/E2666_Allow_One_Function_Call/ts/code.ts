type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type OnceFn = (...args: JSONValue[]) => JSONValue | undefined;

function once(fn: Function): OnceFn {
  let called = false;
  let result: any;

	return function (...args: any[]): any {
		if (!called) {
      result = fn(...args);
      called = true;
      return result;
    } else {
      return undefined;
    }
	};
}

let fn = (a,b,c) => (a + b + c);
let onceFn = once(fn);
let output1 = onceFn(1,2,3);
let output2 = onceFn(2,3,6);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();



