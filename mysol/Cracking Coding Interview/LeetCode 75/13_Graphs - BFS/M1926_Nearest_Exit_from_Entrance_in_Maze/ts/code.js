function nearestExit(maze, entrance) {
    var m = maze.length, n = maze[0].length;
    var queue = [[entrance[0], entrance[1], 0]];
    maze[entrance[0]][entrance[1]] = '+'; // Mark the entrance as visited
    while (queue.length > 0) {
        var _a = queue.shift(), x = _a[0], y = _a[1], dist = _a[2]; // Use non-null assertion since queue is never empty here
        var directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]; // Up, Down, Left, Right
        for (var _i = 0, directions_1 = directions; _i < directions_1.length; _i++) {
            var _b = directions_1[_i], dx = _b[0], dy = _b[1];
            var newX = x + dx, newY = y + dy;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] === '.') {
                if (newX === 0 || newX === m - 1 || newY === 0 || newY === n - 1) {
                    return dist + 1; // Found an exit
                }
                maze[newX][newY] = '+'; // Mark as visited
                queue.push([newX, newY, dist + 1]);
            }
        }
    }
    return -1; // No exit found
}
;
var input1 = [["+", "+", ".", "+"], [".", ".", ".", "+"], ["+", "+", "+", "."]];
var entrance = [1, 2];
var output1 = nearestExit(input1, entrance);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
