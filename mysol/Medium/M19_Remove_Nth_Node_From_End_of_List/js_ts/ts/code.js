class ListNode {
    val;
    next;
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }
}
function removeNthFromEnd(head, n) {
    const dummy = new ListNode(0);
    dummy.next = head;
    let fast = dummy;
    let slow = dummy;
    for (let i = 0; i < n; i++) {
        fast = fast.next;
    }
    while (fast.next !== null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
document.getElementById("title").innerText =
    "19. Remove Nth Node From End of List (TS)";
let output = "";
// Example 1
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
const n1 = 2;
output += "<b>Example 1 Input:</b><br>";
let current1 = head1;
while (current1 !== null) {
    output += current1.val;
    if (current1.next !== null)
        output += " -> ";
    current1 = current1.next;
}
output += "<br>";
output += "<b>n =</b> " + n1 + "<br><br>";
const result1 = removeNthFromEnd(head1, n1);
output += "<b>Example 1 Output:</b><br>";
let out1 = result1;
while (out1 !== null) {
    output += out1.val;
    if (out1.next !== null)
        output += " -> ";
    out1 = out1.next;
}
output += "<br><br>";
// Example 2
const head2 = new ListNode(1);
const n2 = 1;
output += "<b>Example 2 Input:</b><br>";
let current2 = head2;
while (current2 !== null) {
    output += current2.val;
    if (current2.next !== null)
        output += " -> ";
    current2 = current2.next;
}
output += "<br>";
output += "<b>n =</b> " + n2 + "<br><br>";
const result2 = removeNthFromEnd(head2, n2);
output += "<b>Example 2 Output:</b><br>";
let out2 = result2;
while (out2 !== null) {
    output += out2.val;
    if (out2.next !== null)
        output += " -> ";
    out2 = out2.next;
}
output += "<br><br>";
// Example 3
const a = new ListNode(1);
const b = new ListNode(2);
a.next = b;
const head3 = a;
const n3 = 1;
output += "<b>Example 3 Input:</b><br>";
let current3 = head3;
while (current3 !== null) {
    output += current3.val;
    if (current3.next !== null)
        output += " -> ";
    current3 = current3.next;
}
output += "<br>";
output += "<b>n =</b> " + n3 + "<br><br>";
const result3 = removeNthFromEnd(head3, n3);
output += "<b>Example 3 Output:</b><br>";
let out3 = result3;
while (out3 !== null) {
    output += out3.val;
    if (out3.next !== null)
        output += " -> ";
    out3 = out3.next;
}
output += "<br>";
document.getElementById("output").innerHTML = output;
