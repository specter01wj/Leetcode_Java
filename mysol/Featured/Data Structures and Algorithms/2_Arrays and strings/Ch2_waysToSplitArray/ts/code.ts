function answerQueries(nums: number[], queries: number[][], limit: number): boolean[] {
    const prefix: number[] = new Array(nums.length).fill(0);
    prefix[0] = nums[0];

    for (let i = 1; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i];
    }

    const ans: boolean[] = new Array(queries.length);
    for (let i = 0; i < queries.length; i++) {
        const [x, y] = queries[i];
        const curr = prefix[y] - prefix[x] + nums[x];
        ans[i] = curr < limit;
    }

    return ans;
}

const input: number[] = [1, 6, 3, 2, 7, 2];
const queries: number[][] = [[0, 3], [2, 5], [2, 4]];
const limit: number = 13;
const results = answerQueries(input, queries, limit);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

