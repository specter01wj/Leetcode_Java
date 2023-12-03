
declare global {
  interface Array<T> {
      last(): T | -1;
  }
}

Array.prototype.last = function() {
  if (this.length === 0) {
      return -1;
  }
  return this[this.length - 1];
};

// export {};

let input1 = [null, {}, 3], input2 = [];
let output1 = input1.last();
let output2 = input2.last();

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();



