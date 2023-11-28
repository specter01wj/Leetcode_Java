type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function argumentsLength(...args: JSONValue[]): number {
  return args.length;
}

let output = argumentsLength({}, null, "3");

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output.toString();



