function numberOfSubarrays(nums: number[], k: number): number {
    const countMap: Map<number, number> = new Map();
    countMap.set(0, 1);

    let oddCount = 0;
    let result = 0;

    for (const num of nums) {
        if (num % 2 !== 0) oddCount++;

        if (countMap.has(oddCount - k)) {
            result += countMap.get(oddCount - k)!;
        }

        countMap.set(oddCount, (countMap.get(oddCount) || 0) + 1);
    }

    return result;
};

const input: number[] = [1,1,2,1,1];
const k: number = 3;
const results = numberOfSubarrays(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

