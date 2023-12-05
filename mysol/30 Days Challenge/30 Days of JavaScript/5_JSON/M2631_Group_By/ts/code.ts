declare global {
  interface Array<T> {
      groupBy(fn: (item: T) => string): Record<string, T[]>
  }
}

Array.prototype.groupBy = function(fn) {
  const grouped = {};

  for (let i = 0; i < this.length; i++) {
      const key = fn(this[i]);

      if (!grouped[key]) {
          grouped[key] = [];
      }

      grouped[key].push(this[i]);
  }

  return grouped;
}


let input1 = [
  {"id":"1"},
  {"id":"1"},
  {"id":"2"}
];
let fn = function (item) { 
  return item.id; 
};
let output1 = [1,2,3].groupBy(String);
let output2 = input1.groupBy(fn);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();



