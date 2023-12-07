class ArrayWrapper {
  private nums: number[];
  constructor(nums: number[]) {
    this.nums = nums;
  }

  valueOf(): number {
    return this.nums.reduce((acc, num) => acc + num, 0);
  }

  toString(): string {
    return '[' + this.nums.join(',') + ']';
  }
};


let input1 = '';
const obj1 = new ArrayWrapper([1,2]);
const obj2 = new ArrayWrapper([3,4]);

let output1 = obj1 + obj2; // 10
let output2 = String(obj1); // "[1,2]"
let output3 = String(obj2); // "[3,4]"

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);



