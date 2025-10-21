function numJewelsInStones(jewels: string, stones: string): number {
    const jewelSet: Set<string> = new Set(jewels);
    let count: number = 0;

    for (const stone of stones) {
        if (jewelSet.has(stone)) {
            count++;
        }
    }

    return count;
};

const input: string = "aA";
const stones: string = "aAAbbbb";
const results = canConstruct(input, stones);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

