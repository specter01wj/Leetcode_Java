class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function reverseList(head: ListNode | null): ListNode | null {
  let prev: ListNode | null = null;
  let curr: ListNode | null = head;

  while (curr !== null) {
    const nextNode: ListNode | null = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  return prev;
}

function pairSum(head: ListNode): number {

  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  while (fast !== null && fast.next !== null) {
    slow = slow!.next;
    fast = fast.next.next;
  }

  const secondHalf: ListNode | null = reverseList(slow);

  let max: number = 0;

  let firstHalf: ListNode | null = head;
  let currentSecond: ListNode | null = secondHalf;

  while (currentSecond !== null) {
    const sum: number = firstHalf!.val + currentSecond.val;
    if (sum > max) {
      max = sum;
    }
    firstHalf = firstHalf!.next;
    currentSecond = currentSecond.next;
  }

  return max;
}

(document.getElementById("title") as HTMLElement).innerText =
  "2130. Maximum Twin Sum of a Linked List (TS)";

let output: string = "";

// Example 1: head = [5,4,2,1]
const one: ListNode = new ListNode(5);
const two: ListNode = new ListNode(4);
const three: ListNode = new ListNode(2);
const four: ListNode = new ListNode(1);

one.next = two;
two.next = three;
three.next = four;

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

const result1: number = pairSum(head1);

output += "<b>Example 1 Output:</b><br>";
output += result1 + "<br><br>";

// Example 2: head = [4,2,2,3]
const a: ListNode = new ListNode(4);
const b: ListNode = new ListNode(2);
const c: ListNode = new ListNode(2);
const d: ListNode = new ListNode(3);

a.next = b;
b.next = c;
c.next = d;

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

const result2: number = pairSum(head2);

output += "<b>Example 2 Output:</b><br>";
output += result2 + "<br><br>";

// Example 3: head = [1,100000]
const x: ListNode = new ListNode(1);
const y: ListNode = new ListNode(100000);

x.next = y;

const head3: ListNode = x;

output += "<b>Example 3 Input:</b><br>";
let current3: ListNode | null = head3;
while (current3 !== null) {
  output += current3.val;
  if (current3.next !== null) {
    output += " -> ";
  }
  current3 = current3.next;
}
output += "<br><br>";

const result3: number = pairSum(head3);

output += "<b>Example 3 Output:</b><br>";
output += result3;

(document.getElementById("output") as HTMLElement).innerHTML = output;