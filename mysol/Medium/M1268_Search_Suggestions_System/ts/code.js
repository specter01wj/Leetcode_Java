function suggestedProducts(products, searchWord) {
    var _a;
    products.sort();
    var root = buildTrie(products);
    var result = [];
    var node = root;
    for (var _i = 0, searchWord_1 = searchWord; _i < searchWord_1.length; _i++) {
        var char = searchWord_1[_i];
        if (node) {
            node = (_a = node.children[char]) !== null && _a !== void 0 ? _a : null;
        }
        result.push(node ? node.suggestions : []);
    }
    return result;
}
;
var TrieNode = /** @class */ (function () {
    function TrieNode() {
        this.children = {};
        this.suggestions = [];
    }
    return TrieNode;
}());
function buildTrie(products) {
    var root = new TrieNode();
    for (var _i = 0, products_1 = products; _i < products_1.length; _i++) {
        var product = products_1[_i];
        var node = root;
        for (var _a = 0, product_1 = product; _a < product_1.length; _a++) {
            var char = product_1[_a];
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
var products = ["mobile", "mouse", "moneypot", "monitor", "mousepad"];
var searchWord = "mouse";
var output1 = suggestedProducts(products, searchWord);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
