function curry(fn: Function): Function {
    
  return function curried(...args) {
  if (args.length >= fn.length) {
          return fn(...args);
      } else {
          return function(...moreArgs: any[]): any {
              return curried(...args.concat(moreArgs));
          };
      }
  }
};

let input1 = [[1],[2],[3]];
const fn = function sum(a, b, c) { return a + b + c; };

const csum1 = curry(fn);
const csum2 = curry(fn);
const csum3 = curry(fn);

let output1 = csum1(1)(2)(3);
let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let output2 = csum2(1, 2)(3);
let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let output3 = csum3()()(1, 2, 3);
let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);


