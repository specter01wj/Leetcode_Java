class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function swapPairs(head) {
  // Check edge case: linked list has 0 or 1 nodes, just return
  if (head === null || head.next === null) {
    return head;
  }

  let dummy = head.next;   // Step 5
  let prev = null;         // Initialize for step 3

  while (head !== null && head.next !== null) {

    if (prev !== null) {
      prev.next = head.next; // Step 4
    }

    prev = head;             // Step 3

    // Step 2
    const nextNode = head.next.next;

    head.next.next = head;   // Step 1

    head.next = nextNode;    // Step 6
    head = nextNode;         // Move to next pair (Step 3)
  }

  return dummy;
}

document.getElementById("title").innerText =
  "Swap Nodes in Pairs (JS)";

let output = "";

// Case 1: 1 -> 2 -> 3 -> 4
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);

one.next = two;
two.next = three;
three.next = four;

const head1 = one;

output += "<b>Case 1 Input:</b><br>";
let current1 = head1;
while (current1 !== null) {
  output += current1.val;
  if (current1.next !== null) {
    output += " -> ";
  }
  current1 = current1.next;
}
output += "<br><br>";

const result1 = swapPairs(head1);

output += "<b>Case 1 Output:</b><br>";
let out1 = result1;
while (out1 !== null) {
  output += out1.val;
  if (out1.next !== null) {
    output += " -> ";
  }
  out1 = out1.next;
}
output += "<br><br>";

// Case 2: 1 -> 2 -> 3
const a = new ListNode(1);
const b = new ListNode(2);
const c = new ListNode(3);

a.next = b;
b.next = c;

const head2 = a;

output += "<b>Case 2 Input:</b><br>";
let current2 = head2;
while (current2 !== null) {
  output += current2.val;
  if (current2.next !== null) {
    output += " -> ";
  }
  current2 = current2.next;
}
output += "<br><br>";

const result2 = swapPairs(head2);

output += "<b>Case 2 Output:</b><br>";
let out2 = result2;
while (out2 !== null) {
  output += out2.val;
  if (out2.next !== null) {
    output += " -> ";
  }
  out2 = out2.next;
}

document.getElementById("output").innerHTML = output;