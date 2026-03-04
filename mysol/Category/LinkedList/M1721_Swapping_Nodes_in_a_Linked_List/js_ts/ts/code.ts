class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function swapNodes(head: ListNode | null, k: number): ListNode | null {

  let first: ListNode = head as ListNode;

  for (let i: number = 1; i < k; i++) {
    first = first.next as ListNode;
  }

  let fast: ListNode = first;
  let second: ListNode = head as ListNode;

  while (fast.next !== null) {
    fast = fast.next as ListNode;
    second = second.next as ListNode;
  }

  const temp: number = first.val;
  first.val = second.val;
  second.val = temp;

  return head;
}

(document.getElementById("title") as HTMLElement).innerText =
"1721. Swapping Nodes in a Linked List (TS)";

let output: string = "";

// Example 1
const a1: ListNode = new ListNode(1);
const a2: ListNode = new ListNode(2);
const a3: ListNode = new ListNode(3);
const a4: ListNode = new ListNode(4);
const a5: ListNode = new ListNode(5);

a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;

const head1: ListNode = a1;
const k1: number = 2;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";

let p1: ListNode | null = head1;

while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}

output += "<br>k = " + k1 + "<br>";

const result1: ListNode | null = swapNodes(head1, k1);

output += "<b>Output:</b> ";

let q1: ListNode | null = result1;

while (q1 !== null) {
  output += q1.val;
  if (q1.next !== null) output += " -> ";
  q1 = q1.next;
}

output += "<br><br>";


// Example 2
const b1: ListNode = new ListNode(7);
const b2: ListNode = new ListNode(9);
const b3: ListNode = new ListNode(6);
const b4: ListNode = new ListNode(6);
const b5: ListNode = new ListNode(7);
const b6: ListNode = new ListNode(8);
const b7: ListNode = new ListNode(3);
const b8: ListNode = new ListNode(0);
const b9: ListNode = new ListNode(9);
const b10: ListNode = new ListNode(5);

b1.next = b2;
b2.next = b3;
b3.next = b4;
b4.next = b5;
b5.next = b6;
b6.next = b7;
b7.next = b8;
b8.next = b9;
b9.next = b10;

const head2: ListNode = b1;
const k2: number = 5;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";

let p2: ListNode | null = head2;

while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}

output += "<br>k = " + k2 + "<br>";

const result2: ListNode | null = swapNodes(head2, k2);

output += "<b>Output:</b> ";

let q2: ListNode | null = result2;

while (q2 !== null) {
  output += q2.val;
  if (q2.next !== null) output += " -> ";
  q2 = q2.next;
}

(document.getElementById("output") as HTMLElement).innerHTML = output;