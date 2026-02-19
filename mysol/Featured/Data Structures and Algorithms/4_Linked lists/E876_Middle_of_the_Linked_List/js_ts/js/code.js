class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function hasCycle(head) {
  let slow = head;
  let fast = head;

  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow === fast) {
      return true;
    }
  }

  return false;
}

document.getElementById("title").innerText =
  "Linked List Cycle (JS)";

let output = "";

// Case 1: No cycle
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

output += "<b>Case 1 (No Cycle):</b><br>";
let current = head1;
let count = 0;
while (current !== null && count < 10) {
  output += current.val;
  if (current.next !== null) {
    output += " -> ";
  }
  current = current.next;
  count++;
}
output += "<br><br>";

output += "<b>Has Cycle:</b><br>";
output += hasCycle(head1);
output += "<br><br>";

// Case 2: With cycle
const six = new ListNode(1);
const seven = new ListNode(2);
const eight = new ListNode(3);
const nine = new ListNode(4);
const ten = new ListNode(5);

six.next = seven;
seven.next = eight;
eight.next = nine;
nine.next = ten;
ten.next = eight;

const head2 = six;

output += "<b>Case 2 (With Cycle):</b><br>";
output += "1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle)<br><br>";

output += "<b>Has Cycle:</b><br>";
output += hasCycle(head2);

document.getElementById("output").innerHTML = output;