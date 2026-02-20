class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function deleteDuplicates(head) {
  let current = head;

  while (current !== null && current.next !== null) {
    if (current.val === current.next.val) {
      current.next = current.next.next;
    } else {
      current = current.next;
    }
  }

  return head;
}

document.getElementById("title").innerText =
  "83. Remove Duplicates from Sorted List (JS)";

let output = "";

// Example 1: head = [1,1,2]
const one = new ListNode(1);
const two = new ListNode(1);
const three = new ListNode(2);

one.next = two;
two.next = three;

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

const result1 = deleteDuplicates(head1);

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

// Example 2: head = [1,1,2,3,3]
const a = new ListNode(1);
const b = new ListNode(1);
const c = new ListNode(2);
const d = new ListNode(3);
const e = new ListNode(3);

a.next = b;
b.next = c;
c.next = d;
d.next = e;

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

const result2 = deleteDuplicates(head2);

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