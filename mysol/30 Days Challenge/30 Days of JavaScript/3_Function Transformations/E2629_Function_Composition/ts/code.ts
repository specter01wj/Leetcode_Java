type F = (x: number) => number;

function reduce(functions: F[]): F {
  return function(x) {
    return functions.reduceRight((acc, func) => func(acc), x);
  }
}

let fn = compose([x => x + 1, x => 2 * x]);
let output1 = fn(4);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();



