function findCircleNum(isConnected) {
    var n = isConnected.length;
    var visited = new Array(n).fill(false);
    var count = 0;
    function dfs(city) {
        for (var i = 0; i < n; i++) {
            if (isConnected[city][i] === 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
    for (var i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
            count++;
        }
    }
    return count;
}
;
var input1 = [[1, 1, 0], [1, 1, 0], [0, 0, 1]];
var output1 = findCircleNum(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
