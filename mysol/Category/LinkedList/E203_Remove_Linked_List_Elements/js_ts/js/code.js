class ListNode {
  constructor(val, next = null) {
    this.val = val;
    this.next = next;
  }
}

function removeElements(head, val) {

  const dummy = new ListNode(0);
  dummy.next = head;

  let current = dummy;

  while (current.next !== null) {
    if (current.next.val === val) {
      current.next = current.next.next;
    } else {
      current = current.next;
    }
  }

  return dummy.next;
}

document.getElementById("title").innerText =
"203. Remove Linked List Elements (JS)";

let output = "";

// Example 1: head = [1,2,6,3,4,5,6], val = 6
const a1 = new ListNode(1);
const a2 = new ListNode(2);
const a3 = new ListNode(6);
const a4 = new ListNode(3);
const a5 = new ListNode(4);
const a6 = new ListNode(5);
const a7 = new ListNode(6);

a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
a5.next = a6;
a6.next = a7;

const head1 = a1;
const val1 = 6;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";
let p1 = head1;
while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}
output += "<br>";
output += "val = " + val1 + "<br>";

const result1 = removeElements(head1, val1);

output += "<b>Output:</b> ";
let q1 = result1;
while (q1 !== null) {
  output += q1.val;
  if (q1.next !== null) output += " -> ";
  q1 = q1.next;
}
output += "<br><br>";


// Example 2: head = [], val = 1
const head2 = null;
const val2 = 1;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";
let p2 = head2;
while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}
output += "<br>";
output += "val = " + val2 + "<br>";

const result2 = removeElements(head2, val2);

output += "<b>Output:</b> ";
let q2 = result2;
while (q2 !== null) {
  output += q2.val;
  if (q2.next !== null) output += " -> ";
  q2 = q2.next;
}
output += "<br><br>";


// Example 3: head = [7,7,7,7], val = 7
const c1 = new ListNode(7);
const c2 = new ListNode(7);
const c3 = new ListNode(7);
const c4 = new ListNode(7);

c1.next = c2;
c2.next = c3;
c3.next = c4;

const head3 = c1;
const val3 = 7;

output += "<b>=== Example 3 ===</b><br>";
output += "<b>Input :</b> ";
let p3 = head3;
while (p3 !== null) {
  output += p3.val;
  if (p3.next !== null) output += " -> ";
  p3 = p3.next;
}
output += "<br>";
output += "val = " + val3 + "<br>";

const result3 = removeElements(head3, val3);

output += "<b>Output:</b> ";
let q3 = result3;
while (q3 !== null) {
  output += q3.val;
  if (q3.next !== null) output += " -> ";
  q3 = q3.next;
}
output += "<br>";

document.getElementById("output").innerHTML = output;