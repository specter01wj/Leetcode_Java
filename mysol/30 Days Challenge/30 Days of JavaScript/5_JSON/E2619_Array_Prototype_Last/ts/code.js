Array.prototype.last = function () {
    if (this.length === 0) {
        return -1;
    }
    return this[this.length - 1];
};
// export {};
var input1 = [null, {}, 3], input2 = [];
var output1 = input1.last();
var output2 = input2.last();
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
