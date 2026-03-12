class ListNode {
    val;
    next;
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }
}
function oddEvenList(head) {
    if (head === null || head.next === null) {
        return head;
    }
    let odd = head;
    let even = head.next;
    let evenHead = even;
    while (even !== null && even.next !== null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
}
document.getElementById("title").innerText =
    "328. Odd Even Linked List (TS)";
let output = "";
// Example 1: head = [1,2,3,4,5]
const a1 = new ListNode(1);
const a2 = new ListNode(2);
const a3 = new ListNode(3);
const a4 = new ListNode(4);
const a5 = new ListNode(5);
a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
const head1 = a1;
output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";
let p1 = head1;
while (p1 !== null) {
    output += p1.val;
    if (p1.next !== null)
        output += " -> ";
    p1 = p1.next;
}
output += "<br>";
const result1 = oddEvenList(head1);
output += "<b>Output:</b> ";
let q1 = result1;
while (q1 !== null) {
    output += q1.val;
    if (q1.next !== null)
        output += " -> ";
    q1 = q1.next;
}
output += "<br><br>";
// Example 2: head = [2,1,3,5,6,4,7]
const b1 = new ListNode(2);
const b2 = new ListNode(1);
const b3 = new ListNode(3);
const b4 = new ListNode(5);
const b5 = new ListNode(6);
const b6 = new ListNode(4);
const b7 = new ListNode(7);
b1.next = b2;
b2.next = b3;
b3.next = b4;
b4.next = b5;
b5.next = b6;
b6.next = b7;
const head2 = b1;
output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";
let p2 = head2;
while (p2 !== null) {
    output += p2.val;
    if (p2.next !== null)
        output += " -> ";
    p2 = p2.next;
}
output += "<br>";
const result2 = oddEvenList(head2);
output += "<b>Output:</b> ";
let q2 = result2;
while (q2 !== null) {
    output += q2.val;
    if (q2.next !== null)
        output += " -> ";
    q2 = q2.next;
}
output += "<br>";
document.getElementById("output").innerHTML = output;
