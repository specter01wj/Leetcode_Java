function numIdenticalPairs(nums) {
    const freqMap = {};
    let count = 0;
    for (const num of nums) {
        if (freqMap[num]) {
            count += freqMap[num]; // count how many good pairs can be formed
            freqMap[num]++;
        }
        else {
            freqMap[num] = 1;
        }
    }
    return count;
}
;
const input = [1, 2, 3, 1, 1, 3];
const results = numIdenticalPairs(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
