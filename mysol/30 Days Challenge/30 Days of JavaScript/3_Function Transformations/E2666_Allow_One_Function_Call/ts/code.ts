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

let output = argumentsLength({}, null, "3");

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output.toString();



