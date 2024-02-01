var TrieNode = /** @class */ (function () {
    function TrieNode() {
        this.children = {};
        this.isEndOfWord = false;
    }
    return TrieNode;
}());
var Trie = /** @class */ (function () {
    function Trie() {
        this.root = new TrieNode();
    }
    Trie.prototype.insert = function (word) {
        var node = this.root;
        for (var _i = 0, word_1 = word; _i < word_1.length; _i++) {
            var char = word_1[_i];
            if (!node.children[char]) {
                node.children[char] = new TrieNode();
            }
            node = node.children[char];
        }
        node.isEndOfWord = true;
    };
    Trie.prototype.search = function (word) {
        var node = this.searchPrefix(word);
        return node !== null && node.isEndOfWord;
    };
    Trie.prototype.startsWith = function (prefix) {
        return this.searchPrefix(prefix) !== null;
    };
    Trie.prototype.searchPrefix = function (word) {
        var node = this.root;
        for (var _i = 0, word_2 = word; _i < word_2.length; _i++) {
            var char = word_2[_i];
            if (node.children[char]) {
                node = node.children[char];
            }
            else {
                return null;
            }
        }
        return node;
    };
    return Trie;
}());
var trie = new Trie();
trie.insert("apple");
var output1 = trie.search("apple"); // returns true
var output2 = trie.search("app"); // returns false
var output3 = trie.startsWith("app"); // returns true
trie.insert("app");
var output4 = trie.search("app"); // returns true
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
var webHeading4 = document.querySelector('#t4');
webHeading4.textContent = 'Output: ' + JSON.stringify(output4);
