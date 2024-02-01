function suggestedProducts(products: string[], searchWord: string): string[][] {
  products.sort();
  const root = buildTrie(products);
  const result: string[][] = [];
  let node: TrieNode | null = root;

  for (const char of searchWord) {
      if (node) {
          node = node.children[char] ?? null;
      }
      result.push(node ? node.suggestions : []);
  }

  return result;
};

class TrieNode {
  children: { [key: string]: TrieNode };
  suggestions: string[];

  constructor() {
      this.children = {};
      this.suggestions = [];
  }
}

function buildTrie(products: string[]): TrieNode {
  const root = new TrieNode();
  for (const product of products) {
      let node = root;
      for (const char of product) {
          if (!node.children[char]) {
              node.children[char] = new TrieNode();
          }
          node = node.children[char];
          if (node.suggestions.length < 3) {
              node.suggestions.push(product);
          }
      }
  }
  return root;
}

let products = ["mobile", "mouse", "moneypot", "monitor", "mousepad"];
let searchWord = "mouse";
let output1 = suggestedProducts(products, searchWord);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
