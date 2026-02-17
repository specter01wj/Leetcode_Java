class ListNode {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
function findNode(head, k) {
    let slow = head;
    let fast = head;
    for (let i = 0; i < k; i++) {
        fast = fast.next;
    }
    while (fast !== null) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
document.getElementById("title").innerText =
    "Kth Node From End (TS)";
let output = "";
// Build 1 -> 2 -> 3 -> 4 -> 5
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);
const five = new ListNode(5);
one.next = two;
two.next = three;
three.next = four;
four.next = five;
const head = one;
const k = 2;
output += "<b>Input:</b><br>";
let current = head;
while (current !== null) {
    output += current.val;
    if (current.next !== null) {
        output += " -> ";
    }
    current = current.next;
}
output += "<br><br>";
output += "<b>k:</b><br>";
output += k + "<br><br>";
const result = findNode(head, k);
output += "<b>kth node from end:</b><br>";
output += result.val;
document.getElementById("output").innerHTML = output;
