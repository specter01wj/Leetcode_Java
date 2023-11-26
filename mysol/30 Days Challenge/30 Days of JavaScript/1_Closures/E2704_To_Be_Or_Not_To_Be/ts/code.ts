
function expect(val) {
  return {
    toBe: function(expected) {
      if (val === expected) {
        return true;
      } else {
        throw new Error("Not Equal");
      }
    },
    notToBe: function(expected) {
      if (val !== expected) {
        return true;
      } else {
        throw new Error("Equal");
      }
    }
  }
}

let input = '';
let output1 = expect(5).toBe(5);
let output2 = expect(5).notToBe(15);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();


