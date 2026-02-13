/*
 * Chapter 4 – Linked Lists
 *
 * Example 1: Create and Traverse a Singly Linked List
 */
class ListNode {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
function createLinkedList() {
    const one = new ListNode(1);
    const two = new ListNode(2);
    const three = new ListNode(3);
    // Link nodes: 1 → 2 → 3 → null
    one.next = two;
    two.next = three;
    return one; // head
}
function traverseLinkedList(head) {
    const values = [];
    let current = head;
    while (current !== null) {
        values.push(current.val);
        current = current.next;
    }
    return values;
}
/* ===============================
   Testing Section
=============================== */
const head = createLinkedList();
const result = traverseLinkedList(head);
let output = "<h2>>> Chapter 4 – Linked List: Create & Traverse</h2>";
output += "<b>Structure:</b><br>1 → 2 → 3 → null<br><br>";
output += "<b>Traversal Output:</b><br>" + result.join(" → ");
document.querySelector('#t1').innerHTML = output;
