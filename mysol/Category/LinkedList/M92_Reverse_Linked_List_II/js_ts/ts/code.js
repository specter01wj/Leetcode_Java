class ListNode {
    val;
    next;
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }
}
function reverseBetween(head, left, right) {
    if (head === null || left === right) {
        return head;
    }
    const dummy = new ListNode(0, head);
    let prev = dummy;
    for (let i = 1; i < left; i++) {
        prev = prev.next;
    }
    let curr = prev.next;
    for (let i = 0; i < right - left; i++) {
        const nextNode = curr.next;
        curr.next = nextNode.next;
        nextNode.next = prev.next;
        prev.next = nextNode;
    }
    return dummy.next;
}
document.getElementById("title").innerText =
    "92. Reverse Linked List II (TS)";
let output = "";
// Example 1: head = [1,2,3,4,5], left = 2, right = 4
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);
const five = new ListNode(5);
one.next = two;
two.next = three;
three.next = four;
four.next = five;
const head1 = one;
const left1 = 2;
const right1 = 4;
output += "<b>Example 1 Input:</b><br>";
let current1 = head1;
while (current1 !== null) {
    output += current1.val;
    if (current1.next !== null) {
        output += " -> ";
    }
    current1 = current1.next;
}
output += "<br>";
output += "<b>left =</b> " + left1 + ", <b>right =</b> " + right1 + "<br><br>";
const result1 = reverseBetween(head1, left1, right1);
output += "<b>Example 1 Output:</b><br>";
let out1 = result1;
while (out1 !== null) {
    output += out1.val;
    if (out1.next !== null) {
        output += " -> ";
    }
    out1 = out1.next;
}
output += "<br><br>";
// Example 2: head = [5], left = 1, right = 1
const head2 = new ListNode(5);
const left2 = 1;
const right2 = 1;
output += "<b>Example 2 Input:</b><br>";
let current2 = head2;
while (current2 !== null) {
    output += current2.val;
    if (current2.next !== null) {
        output += " -> ";
    }
    current2 = current2.next;
}
output += "<br>";
output += "<b>left =</b> " + left2 + ", <b>right =</b> " + right2 + "<br><br>";
const result2 = reverseBetween(head2, left2, right2);
output += "<b>Example 2 Output:</b><br>";
let out2 = result2;
while (out2 !== null) {
    output += out2.val;
    if (out2.next !== null) {
        output += " -> ";
    }
    out2 = out2.next;
}
document.getElementById("output").innerHTML = output;
