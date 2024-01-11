function minReorder(n, connections) {
    var al = Array.from({ length: n }, function () { return []; });
    for (var _i = 0, connections_1 = connections; _i < connections_1.length; _i++) {
        var c = connections_1[_i];
        al[c[0]].push(c[1]);
        al[c[1]].push(-c[0]); // Negative to indicate reverse direction
    }
    var visited = new Array(n).fill(false);
    var dfs = function (from) {
        var change = 0;
        visited[from] = true;
        for (var _i = 0, _a = al[from]; _i < _a.length; _i++) {
            var to = _a[_i];
            if (!visited[Math.abs(to)]) {
                change += dfs(Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    };
    return dfs(0);
}
;
var input1 = [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]];
var n = 6;
var output1 = minReorder(n, input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
