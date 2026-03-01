class ListNode {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
function deleteMiddle(head, log) {
    if (head === null) {
        return null;
    }
    if (head.next === null) {
        return null;
    }
    let slow = head;
    let fast = head;
    let prev = null;
    let step = 0;
    while (fast !== null && fast.next !== null) {
        step++;
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
        log.push("Step " + step +
            ": prev=" + prev.val +
            ", slow=" + slow.val +
            ", fast=" + (fast === null ? "null" : fast.val));
    }
    log.push("Delete node (middle): " + slow.val);
    prev.next = slow.next;
    return head;
}
document.getElementById("title").innerText =
    "2095. Delete the Middle Node of a Linked List (TS)";
let output = "";
// Example 1: [1,3,4,7,1,2,6]
let a1 = new ListNode(1);
let a2 = new ListNode(3);
let a3 = new ListNode(4);
let a4 = new ListNode(7);
let a5 = new ListNode(1);
let a6 = new ListNode(2);
let a7 = new ListNode(6);
a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
a5.next = a6;
a6.next = a7;
let head1 = a1;
output += "<b>=== Example 1 ===</b><br>";
output += "<b>Before:</b> ";
let p1 = head1;
while (p1 !== null) {
    output += p1.val;
    if (p1.next !== null)
        output += " -> ";
    p1 = p1.next;
}
output += "<br>";
let log1 = [];
head1 = deleteMiddle(head1, log1);
for (let i = 0; i < log1.length; i++) {
    output += log1[i] + "<br>";
}
output += "<b>After :</b> ";
let q1 = head1;
while (q1 !== null) {
    output += q1.val;
    if (q1.next !== null)
        output += " -> ";
    q1 = q1.next;
}
output += "<br><br>";
// Example 2: [1,2,3,4]
let b1 = new ListNode(1);
let b2 = new ListNode(2);
let b3 = new ListNode(3);
let b4 = new ListNode(4);
b1.next = b2;
b2.next = b3;
b3.next = b4;
let head2 = b1;
output += "<b>=== Example 2 ===</b><br>";
output += "<b>Before:</b> ";
let p2 = head2;
while (p2 !== null) {
    output += p2.val;
    if (p2.next !== null)
        output += " -> ";
    p2 = p2.next;
}
output += "<br>";
let log2 = [];
head2 = deleteMiddle(head2, log2);
for (let i = 0; i < log2.length; i++) {
    output += log2[i] + "<br>";
}
output += "<b>After :</b> ";
let q2 = head2;
while (q2 !== null) {
    output += q2.val;
    if (q2.next !== null)
        output += " -> ";
    q2 = q2.next;
}
output += "<br><br>";
// Example 3: [2,1]
let c1 = new ListNode(2);
let c2 = new ListNode(1);
c1.next = c2;
let head3 = c1;
output += "<b>=== Example 3 ===</b><br>";
output += "<b>Before:</b> ";
let p3 = head3;
while (p3 !== null) {
    output += p3.val;
    if (p3.next !== null)
        output += " -> ";
    p3 = p3.next;
}
output += "<br>";
let log3 = [];
head3 = deleteMiddle(head3, log3);
for (let i = 0; i < log3.length; i++) {
    output += log3[i] + "<br>";
}
output += "<b>After :</b> ";
let q3 = head3;
while (q3 !== null) {
    output += q3.val;
    if (q3.next !== null)
        output += " -> ";
    q3 = q3.next;
}
output += "<br>";
document.getElementById("output").innerHTML = output;
