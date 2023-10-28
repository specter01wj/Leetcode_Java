
function minMaxGame(nums: number[]): number {
    while (nums.length > 1) {
        let n = nums.length;
        let newNums: number[] = new Array(Math.floor(n / 2)).fill(0);
        
        for (let i = 0; i < Math.floor(n / 2); i++) {
            if (i % 2 === 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
            
        nums = newNums;
    }

    return nums[0];
}

let input = [1,3,5,2,4,8,2,2];
let output = minMaxGame(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


