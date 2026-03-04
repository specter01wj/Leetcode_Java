class ListNode {
  constructor(val, next = null) {
    this.val = val;
    this.next = next;
  }
}

function swapNodes(head, k) {

  let first = head;
  for (let i = 1; i < k; i++) {
    first = first.next;
  }

  let fast = first;
  let second = head;

  while (fast.next !== null) {
    fast = fast.next;
    second = second.next;
  }

  const temp = first.val;
  first.val = second.val;
  second.val = temp;

  return head;
}

document.getElementById("title").innerText =
"1721. Swapping Nodes in a Linked List (JS)";

let output = "";

// Example 1
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
const k1 = 2;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";

let p1 = head1;
while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}

output += "<br>k = " + k1 + "<br>";

const result1 = swapNodes(head1, k1);

output += "<b>Output:</b> ";

let q1 = result1;
while (q1 !== null) {
  output += q1.val;
  if (q1.next !== null) output += " -> ";
  q1 = q1.next;
}

output += "<br><br>";


// Example 2
const b1 = new ListNode(7);
const b2 = new ListNode(9);
const b3 = new ListNode(6);
const b4 = new ListNode(6);
const b5 = new ListNode(7);
const b6 = new ListNode(8);
const b7 = new ListNode(3);
const b8 = new ListNode(0);
const b9 = new ListNode(9);
const b10 = new ListNode(5);

b1.next = b2;
b2.next = b3;
b3.next = b4;
b4.next = b5;
b5.next = b6;
b6.next = b7;
b7.next = b8;
b8.next = b9;
b9.next = b10;

const head2 = b1;
const k2 = 5;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";

let p2 = head2;
while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}

output += "<br>k = " + k2 + "<br>";

const result2 = swapNodes(head2, k2);

output += "<b>Output:</b> ";

let q2 = result2;
while (q2 !== null) {
  output += q2.val;
  if (q2.next !== null) output += " -> ";
  q2 = q2.next;
}

document.getElementById("output").innerHTML = output;