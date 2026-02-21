class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
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

document.getElementById("title").innerText =
  "Reverse Linked List (JS)";

let output = "";

// Build 1 -> 2 -> 3 -> 4
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);

one.next = two;
two.next = three;
three.next = four;

const head = one;

output += "<b>Input:</b><br>";
let current1 = head;
while (current1 !== null) {
  output += current1.val;
  if (current1.next !== null) {
    output += " -> ";
  }
  current1 = current1.next;
}
output += "<br><br>";

const reversed = reverseList(head);

output += "<b>Output:</b><br>";
let current2 = reversed;
while (current2 !== null) {
  output += current2.val;
  if (current2.next !== null) {
    output += " -> ";
  }
  current2 = current2.next;
}

document.getElementById("output").innerHTML = output;