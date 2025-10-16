function equalPairs(grid: number[][]): number {
    const n = grid.length;
    const rowMap = new Map<string, number>();

    // Store serialized rows in map
    for (const row of grid) {
        const key = row.join(',');
        rowMap.set(key, (rowMap.get(key) ?? 0) + 1);
    }

    let count = 0;

    // Compare serialized columns to map
    for (let col = 0; col < n; col++) {
        const colArr: number[] = [];
        for (let row = 0; row < n; row++) {
            colArr.push(grid[row][col]);
        }
        const key = colArr.join(',');
        if (rowMap.has(key)) {
            count += rowMap.get(key)!;
        }
    }

    return count;
};

const input: number[][] = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]];
const results = equalPairs(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

