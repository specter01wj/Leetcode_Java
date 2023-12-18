function expect(val) {
    return {
        toBe: function (expected) {
            if (val === expected) {
                return true;
            }
            else {
                throw new Error("Not Equal");
            }
        },
        notToBe: function (expected) {
            if (val !== expected) {
                return true;
            }
            else {
                throw new Error("Equal");
            }
        }
    };
}
var input = '';
var output1 = expect(5).toBe(5);
var output2 = expect(5).notToBe(15);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
