class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function middleNode(head) {
  let slow = head;
  let fast = head;

  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
}

document.getElementById("title").innerText =
  "876. Middle of the Linked List (JS)";

let output = "";

// Example 1: head = [1,2,3,4,5]
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

const mid1 = middleNode(head1);

output += "<b>Example 1 Output:</b><br>";
let out1 = mid1;
while (out1 !== null) {
  output += out1.val;
  if (out1.next !== null) {
    output += " -> ";
  }
  out1 = out1.next;
}
output += "<br><br>";

// Example 2: head = [1,2,3,4,5,6]
const a = new ListNode(1);
const b = new ListNode(2);
const c = new ListNode(3);
const d = new ListNode(4);
const e = new ListNode(5);
const f = new ListNode(6);

a.next = b;
b.next = c;
c.next = d;
d.next = e;
e.next = f;

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

const mid2 = middleNode(head2);

output += "<b>Example 2 Output:</b><br>";
let out2 = mid2;
while (out2 !== null) {
  output += out2.val;
  if (out2.next !== null) {
    output += " -> ";
  }
  out2 = out2.next;
}

document.getElementById("output").innerHTML = output;