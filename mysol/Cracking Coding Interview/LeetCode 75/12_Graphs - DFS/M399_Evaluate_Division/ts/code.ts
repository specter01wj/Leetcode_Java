function calcEquation(equations: string[][], values: number[], queries: string[][]): number[] {
  const graph = new Map<string, Map<string, number>>();

  // Build the graph
  equations.forEach((equation, index) => {
      const [dividend, divisor] = equation;
      const value = values[index];

      if (!graph.has(dividend)) graph.set(dividend, new Map());
      graph.get(dividend)!.set(divisor, value);

      if (!graph.has(divisor)) graph.set(divisor, new Map());
      graph.get(divisor)!.set(dividend, 1 / value);
  });

  // DFS function to find the product of the path
  const dfs = (node: string, target: string, visited: Set<string>): number => {
      if (!graph.has(node) || visited.has(node)) return -1;
      if (node === target) return 1;

      visited.add(node);
      const neighbors = graph.get(node)!;
      for (let [neighbor, value] of neighbors) {
          const product = dfs(neighbor, target, visited);
          if (product !== -1) return product * value;
      }

      return -1;
  };

  // Process queries
  return queries.map(([dividend, divisor]) => {
      if (!graph.has(dividend) || !graph.has(divisor)) return -1;
      return dfs(dividend, divisor, new Set<string>());
  });
};

let equations = [["a","b"],["b","c"]];
let values = [2.0,3.0];
let queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]];
let output1 = calcEquation(equations, values, queries);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

