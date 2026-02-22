class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {

  if (head === null || left === right) {
    return head;
  }

  const dummy: ListNode = new ListNode(0, head);

  let prev: ListNode = dummy;
  for (let i: number = 1; i < left; i++) {
    prev = prev.next as ListNode;
  }

  let curr: ListNode = prev.next as ListNode;

  for (let i: number = 0; i < right - left; i++) {
    const nextNode: ListNode = curr.next as ListNode;
    curr.next = nextNode.next;
    nextNode.next = prev.next;
    prev.next = nextNode;
  }

  return dummy.next;
}

(document.getElementById("title") as HTMLElement).innerText =
  "92. Reverse Linked List II (TS)";

let output: string = "";

// Example 1: head = [1,2,3,4,5], left = 2, right = 4
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
const left1: number = 2;
const right1: number = 4;

output += "<b>Example 1 Input:</b><br>";
let current1: ListNode | null = head1;
while (current1 !== null) {
  output += current1.val;
  if (current1.next !== null) {
    output += " -> ";
  }
  current1 = current1.next;
}
output += "<br>";
output += "<b>left =</b> " + left1 + ", <b>right =</b> " + right1 + "<br><br>";

const result1: ListNode | null = reverseBetween(head1, left1, right1);

output += "<b>Example 1 Output:</b><br>";
let out1: ListNode | null = result1;
while (out1 !== null) {
  output += out1.val;
  if (out1.next !== null) {
    output += " -> ";
  }
  out1 = out1.next;
}
output += "<br><br>";

// Example 2: head = [5], left = 1, right = 1
const head2: ListNode = new ListNode(5);
const left2: number = 1;
const right2: number = 1;

output += "<b>Example 2 Input:</b><br>";
let current2: ListNode | null = head2;
while (current2 !== null) {
  output += current2.val;
  if (current2.next !== null) {
    output += " -> ";
  }
  current2 = current2.next;
}
output += "<br>";
output += "<b>left =</b> " + left2 + ", <b>right =</b> " + right2 + "<br><br>";

const result2: ListNode | null = reverseBetween(head2, left2, right2);

output += "<b>Example 2 Output:</b><br>";
let out2: ListNode | null = result2;
while (out2 !== null) {
  output += out2.val;
  if (out2.next !== null) {
    output += " -> ";
  }
  out2 = out2.next;
}

(document.getElementById("output") as HTMLElement).innerHTML = output;