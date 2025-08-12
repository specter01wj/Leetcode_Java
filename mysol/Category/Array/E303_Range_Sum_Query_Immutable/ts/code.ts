class NumArray {
    private pre: number[];

    constructor(nums: number[]) {
        this.pre = new Array(nums.length + 1).fill(0);
        for (let i = 0; i < nums.length; i++) {
            this.pre[i + 1] = this.pre[i] + nums[i];
        }
    }

    sumRange(left: number, right: number): number {
        return this.pre[right + 1] - this.pre[left];
    }
}

const input: number[] = [-2, 0, 3, -5, 2, -1];
const numArray = new NumArray(input);
const results = numArray.sumRange(0, 2);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

