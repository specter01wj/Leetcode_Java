function orArray(nums) {
    const n = nums.length;
    const answer = new Array(n - 1);
    for (let i = 0; i < n - 1; i++) {
        answer[i] = nums[i] | nums[i + 1];
    }
    return answer;
}
;
const input = [1, 3, 7, 15];
const results = orArray(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
