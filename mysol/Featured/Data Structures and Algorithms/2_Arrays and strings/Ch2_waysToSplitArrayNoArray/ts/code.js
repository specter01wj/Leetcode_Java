function waysToSplitArrayNoArray(nums) {
    let ans = 0;
    let leftSection = 0;
    let total = 0;
    for (let num of nums) {
        total += num;
    }
    for (let i = 0; i < nums.length - 1; i++) {
        leftSection += nums[i];
        let rightSection = total - leftSection;
        if (leftSection >= rightSection) {
            ans++;
        }
    }
    return ans;
}
const input = [10, 4, -8, 7];
const results = waysToSplitArrayNoArray(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
