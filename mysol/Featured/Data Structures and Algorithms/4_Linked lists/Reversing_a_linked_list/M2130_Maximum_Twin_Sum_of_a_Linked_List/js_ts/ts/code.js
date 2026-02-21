class ListNode {
    val;
    next;
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }
}
function reverseList(head) {
    let prev = null;
    let curr = head;
    while (curr !== null) {
        const nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}
function pairSum(head) {
    let slow = head;
    let fast = head;
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    const secondHalf = reverseList(slow);
    let max = 0;
    let firstHalf = head;
    let currentSecond = secondHalf;
    while (currentSecond !== null) {
        const sum = firstHalf.val + currentSecond.val;
        if (sum > max) {
            max = sum;
        }
        firstHalf = firstHalf.next;
        currentSecond = currentSecond.next;
    }
    return max;
}
document.getElementById("title").innerText =
    "2130. Maximum Twin Sum of a Linked List (TS)";
let output = "";
// Example 1: head = [5,4,2,1]
const one = new ListNode(5);
const two = new ListNode(4);
const three = new ListNode(2);
const four = new ListNode(1);
one.next = two;
two.next = three;
three.next = four;
const head1 = one;
output += "<b>Example 1 Input:</b><br>";
let current1 = head1;
while (current1 !== null) {
    output += current1.val;
    if (current1.next !== null) {
        output += " -> ";
    }
    current1 = current1.next;
}
output += "<br><br>";
const result1 = pairSum(head1);
output += "<b>Example 1 Output:</b><br>";
output += result1 + "<br><br>";
// Example 2: head = [4,2,2,3]
const a = new ListNode(4);
const b = new ListNode(2);
const c = new ListNode(2);
const d = new ListNode(3);
a.next = b;
b.next = c;
c.next = d;
const head2 = a;
output += "<b>Example 2 Input:</b><br>";
let current2 = head2;
while (current2 !== null) {
    output += current2.val;
    if (current2.next !== null) {
        output += " -> ";
    }
    current2 = current2.next;
}
output += "<br><br>";
const result2 = pairSum(head2);
output += "<b>Example 2 Output:</b><br>";
output += result2 + "<br><br>";
// Example 3: head = [1,100000]
const x = new ListNode(1);
const y = new ListNode(100000);
x.next = y;
const head3 = x;
output += "<b>Example 3 Input:</b><br>";
let current3 = head3;
while (current3 !== null) {
    output += current3.val;
    if (current3.next !== null) {
        output += " -> ";
    }
    current3 = current3.next;
}
output += "<br><br>";
const result3 = pairSum(head3);
output += "<b>Example 3 Output:</b><br>";
output += result3;
document.getElementById("output").innerHTML = output;
