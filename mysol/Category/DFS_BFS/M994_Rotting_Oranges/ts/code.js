function orangesRotting(grid) {
    if (!grid || grid.length === 0)
        return -1;
    var freshCount = 0;
    var queue = [];
    var m = grid.length, n = grid[0].length;
    // Initialize with all rotten oranges and count fresh oranges
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] === 2) {
                queue.push([i, j]);
            }
            else if (grid[i][j] === 1) {
                freshCount++;
            }
        }
    }
    if (freshCount === 0)
        return 0; // No fresh oranges initially
    var minutes = 0;
    var directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]; // 4-directional
    while (queue.length > 0 && freshCount > 0) {
        var size = queue.length;
        for (var i = 0; i < size; i++) {
            var _a = queue.shift(), x = _a[0], y = _a[1];
            for (var _i = 0, directions_1 = directions; _i < directions_1.length; _i++) {
                var _b = directions_1[_i], dx = _b[0], dy = _b[1];
                var newX = x + dx, newY = y + dy;
                if (newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] !== 1) {
                    continue;
                }
                grid[newX][newY] = 2; // Rot the fresh orange
                queue.push([newX, newY]);
                freshCount--;
            }
        }
        minutes++;
    }
    return freshCount === 0 ? minutes : -1;
}
;
var input1 = [[2, 1, 1], [1, 1, 0], [0, 1, 1]];
var output1 = orangesRotting(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
