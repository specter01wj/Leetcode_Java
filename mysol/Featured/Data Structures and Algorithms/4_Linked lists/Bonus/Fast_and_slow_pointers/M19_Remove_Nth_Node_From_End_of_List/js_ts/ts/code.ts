class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function removeNthFromEnd(head: ListNode | null, n: number): ListNode | null {

  const dummy: ListNode = new ListNode(0);
  dummy.next = head;

  let fast: ListNode = dummy;
  let slow: ListNode = dummy;

  for (let i: number = 0; i < n; i++) {
    fast = fast.next as ListNode;
  }

  while (fast.next !== null) {
    fast = fast.next as ListNode;
    slow = slow.next as ListNode;
  }

  slow.next = slow.next!.next;

  return dummy.next;
}

(document.getElementById("title") as HTMLElement).innerText =
  "19. Remove Nth Node From End of List (TS)";

let output: string = "";

// Example 1
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
const n1: number = 2;

output += "<b>Example 1 Input:</b><br>";
let current1: ListNode | null = head1;
while (current1 !== null) {
  output += current1.val;
  if (current1.next !== null) output += " -> ";
  current1 = current1.next;
}
output += "<br>";
output += "<b>n =</b> " + n1 + "<br><br>";

const result1: ListNode | null = removeNthFromEnd(head1, n1);

output += "<b>Example 1 Output:</b><br>";
let out1: ListNode | null = result1;
while (out1 !== null) {
  output += out1.val;
  if (out1.next !== null) output += " -> ";
  out1 = out1.next;
}
output += "<br><br>";


// Example 2
const head2: ListNode = new ListNode(1);
const n2: number = 1;

output += "<b>Example 2 Input:</b><br>";
let current2: ListNode | null = head2;
while (current2 !== null) {
  output += current2.val;
  if (current2.next !== null) output += " -> ";
  current2 = current2.next;
}
output += "<br>";
output += "<b>n =</b> " + n2 + "<br><br>";

const result2: ListNode | null = removeNthFromEnd(head2, n2);

output += "<b>Example 2 Output:</b><br>";
let out2: ListNode | null = result2;
while (out2 !== null) {
  output += out2.val;
  if (out2.next !== null) output += " -> ";
  out2 = out2.next;
}
output += "<br><br>";


// Example 3
const a: ListNode = new ListNode(1);
const b: ListNode = new ListNode(2);
a.next = b;

const head3: ListNode = a;
const n3: number = 1;

output += "<b>Example 3 Input:</b><br>";
let current3: ListNode | null = head3;
while (current3 !== null) {
  output += current3.val;
  if (current3.next !== null) output += " -> ";
  current3 = current3.next;
}
output += "<br>";
output += "<b>n =</b> " + n3 + "<br><br>";

const result3: ListNode | null = removeNthFromEnd(head3, n3);

output += "<b>Example 3 Output:</b><br>";
let out3: ListNode | null = result3;
while (out3 !== null) {
  output += out3.val;
  if (out3.next !== null) output += " -> ";
  out3 = out3.next;
}
output += "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;