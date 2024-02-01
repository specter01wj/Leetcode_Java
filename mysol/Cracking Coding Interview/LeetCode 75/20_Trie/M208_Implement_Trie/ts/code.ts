class TrieNode {
  children: { [key: string]: TrieNode };
  isEndOfWord: boolean;

  constructor() {
      this.children = {};
      this.isEndOfWord = false;
  }
}

class Trie {
  private root: TrieNode;

  constructor() {
      this.root = new TrieNode();
  }

  insert(word: string): void {
      let node = this.root;
      for (let char of word) {
          if (!node.children[char]) {
              node.children[char] = new TrieNode();
          }
          node = node.children[char];
      }
      node.isEndOfWord = true;
  }

  search(word: string): boolean {
      const node = this.searchPrefix(word);
      return node !== null && node.isEndOfWord;
  }

  startsWith(prefix: string): boolean {
      return this.searchPrefix(prefix) !== null;
  }

  private searchPrefix(word: string): TrieNode | null {
      let node = this.root;
      for (let char of word) {
          if (node.children[char]) {
              node = node.children[char];
          } else {
              return null;
          }
      }
      return node;
  }
}

let trie = new Trie();
trie.insert("apple");
let output1 = trie.search("apple");   // returns true
let output2 = trie.search("app");     // returns false
let output3 = trie.startsWith("app"); // returns true
trie.insert("app");
let output4 = trie.search("app");     // returns true

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);

let webHeading4 = document.querySelector('#t4');
webHeading4.textContent = 'Output: ' + JSON.stringify(output4);

