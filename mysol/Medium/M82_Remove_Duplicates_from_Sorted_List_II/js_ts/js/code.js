class ListNode {
  constructor(val, next = null) {
    this.val = val;
    this.next = next;
  }
}

// Implementation (submission-style only). No prints here.
function deleteDuplicates(head) {

  const dummy = new ListNode(0, head);

  let prev = dummy;
  let curr = head;

  while (curr !== null) {

    if (curr.next !== null && curr.val === curr.next.val) {

      const dupVal = curr.val;

      while (curr !== null && curr.val === dupVal) {
        curr = curr.next;
      }

      prev.next = curr;

    } else {

      prev = curr;
      curr = curr.next;
    }
  }

  return dummy.next;
}

document.getElementById("title").innerText =
  "82. Remove Duplicates from Sorted List II (JS)";

let output = "";

// Example 1: head = [1,2,3,3,4,4,5]
const a1 = new ListNode(1);
const a2 = new ListNode(2);
const a3 = new ListNode(3);
const a4 = new ListNode(3);
const a5 = new ListNode(4);
const a6 = new ListNode(4);
const a7 = new ListNode(5);

a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
a5.next = a6;
a6.next = a7;

const head1 = a1;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";
let p1 = head1;
while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}
output += "<br>";

const result1 = deleteDuplicates(head1);

output += "<b>Output:</b> ";
let q1 = result1;
while (q1 !== null) {
  output += q1.val;
  if (q1.next !== null) output += " -> ";
  q1 = q1.next;
}
output += "<br><br>";


// Example 2: head = [1,1,1,2,3]
const b1 = new ListNode(1);
const b2 = new ListNode(1);
const b3 = new ListNode(1);
const b4 = new ListNode(2);
const b5 = new ListNode(3);

b1.next = b2;
b2.next = b3;
b3.next = b4;
b4.next = b5;

const head2 = b1;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";
let p2 = head2;
while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}
output += "<br>";

const result2 = deleteDuplicates(head2);

output += "<b>Output:</b> ";
let q2 = result2;
while (q2 !== null) {
  output += q2.val;
  if (q2.next !== null) output += " -> ";
  q2 = q2.next;
}
output += "<br>";

document.getElementById("output").innerHTML = output;