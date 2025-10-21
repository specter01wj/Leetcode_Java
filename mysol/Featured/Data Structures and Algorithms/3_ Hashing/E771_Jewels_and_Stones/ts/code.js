function numJewelsInStones(jewels, stones) {
    const jewelSet = new Set(jewels);
    let count = 0;
    for (const stone of stones) {
        if (jewelSet.has(stone)) {
            count++;
        }
    }
    return count;
}
;
const input = "aA";
const stones = "aAAbbbb";
const results = numJewelsInStones(input, stones);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
