class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function middleNode(head: ListNode): ListNode {
  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  while (fast !== null && fast.next !== null) {
    slow = slow!.next;
    fast = fast.next.next;
  }

  return slow!;
}

(document.getElementById("title") as HTMLElement).innerText =
  "876. Middle of the Linked List (TS)";

let output: string = "";

// Example 1: head = [1,2,3,4,5]
const one: ListNode = new ListNode(1);
const two: ListNode = new ListNode(2);
const three: ListNode = new ListNode(3);
const four: ListNode = new ListNode(4);
const five: ListNode = new ListNode(5);

one.next = two;
two.next = three;
three.next = four;
four.next = five;

const head1: ListNode = one;

output += "<b>Example 1 Input:</b><br>";
let current1: ListNode | null = head1;
while (current1 !== null) {
  output += current1.val;
  if (current1.next !== null) {
    output += " -> ";
  }
  current1 = current1.next;
}
output += "<br><br>";

const mid1: ListNode = middleNode(head1);

output += "<b>Example 1 Output:</b><br>";
let out1: ListNode | null = mid1;
while (out1 !== null) {
  output += out1.val;
  if (out1.next !== null) {
    output += " -> ";
  }
  out1 = out1.next;
}
output += "<br><br>";

// Example 2: head = [1,2,3,4,5,6]
const a: ListNode = new ListNode(1);
const b: ListNode = new ListNode(2);
const c: ListNode = new ListNode(3);
const d: ListNode = new ListNode(4);
const e: ListNode = new ListNode(5);
const f: ListNode = new ListNode(6);

a.next = b;
b.next = c;
c.next = d;
d.next = e;
e.next = f;

const head2: ListNode = a;

output += "<b>Example 2 Input:</b><br>";
let current2: ListNode | null = head2;
while (current2 !== null) {
  output += current2.val;
  if (current2.next !== null) {
    output += " -> ";
  }
  current2 = current2.next;
}
output += "<br><br>";

const mid2: ListNode = middleNode(head2);

output += "<b>Example 2 Output:</b><br>";
let out2: ListNode | null = mid2;
while (out2 !== null) {
  output += out2.val;
  if (out2.next !== null) {
    output += " -> ";
  }
  out2 = out2.next;
}

(document.getElementById("output") as HTMLElement).innerHTML = output;