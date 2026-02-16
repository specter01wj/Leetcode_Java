class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function getMiddle(head) {
  let slow = head;
  let fast = head;

  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow.val;
}

document.getElementById("title").innerText =
  "Fast & Slow Pointers - Middle Node (JS)";

// Build 1 -> 2 -> 3 -> 4 -> 5
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);
const five = new ListNode(5);

one.next = two;
two.next = three;
three.next = four;
four.next = five;

const head = one;

let output = "";

output += "<b>Input:</b><br>";
let current = head;
while (current !== null) {
  output += current.val;
  if (current.next !== null) {
    output += " -> ";
  }
  current = current.next;
}
output += "<br><br>";

const middle = getMiddle(head);

output += "<b>Middle value:</b><br>";
output += middle;

document.getElementById("output").innerHTML = output;