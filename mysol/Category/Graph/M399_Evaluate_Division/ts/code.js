function calcEquation(equations, values, queries) {
    var graph = new Map();
    // Build the graph
    equations.forEach(function (equation, index) {
        var dividend = equation[0], divisor = equation[1];
        var value = values[index];
        if (!graph.has(dividend))
            graph.set(dividend, new Map());
        graph.get(dividend).set(divisor, value);
        if (!graph.has(divisor))
            graph.set(divisor, new Map());
        graph.get(divisor).set(dividend, 1 / value);
    });
    // DFS function to find the product of the path
    var dfs = function (node, target, visited) {
        if (!graph.has(node) || visited.has(node))
            return -1;
        if (node === target)
            return 1;
        visited.add(node);
        var neighbors = graph.get(node);
        for (var _i = 0, neighbors_1 = neighbors; _i < neighbors_1.length; _i++) {
            var _a = neighbors_1[_i], neighbor = _a[0], value = _a[1];
            var product = dfs(neighbor, target, visited);
            if (product !== -1)
                return product * value;
        }
        return -1;
    };
    // Process queries
    return queries.map(function (_a) {
        var dividend = _a[0], divisor = _a[1];
        if (!graph.has(dividend) || !graph.has(divisor))
            return -1;
        return dfs(dividend, divisor, new Set());
    });
}
;
var equations = [["a", "b"], ["b", "c"]];
var values = [2.0, 3.0];
var queries = [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]];
var output1 = calcEquation(equations, values, queries);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
