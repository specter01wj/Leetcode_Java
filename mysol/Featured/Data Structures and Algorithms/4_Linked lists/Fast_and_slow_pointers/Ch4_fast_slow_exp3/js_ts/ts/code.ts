class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function detectCycle(head: ListNode | null): boolean {
  const seen: Set<ListNode> = new Set();

  while (head !== null) {
    if (seen.has(head)) {
      return true;
    }
    seen.add(head);
    head = head.next;
  }

  return false;
}

(document.getElementById("title") as HTMLElement).innerText =
  "Linked List Cycle - Hashing (TS)";

let output: string = "";

// Case 1: No cycle
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

output += "<b>Case 1 (No Cycle):</b><br>";
let current: ListNode | null = head1;
let count: number = 0;
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
output += detectCycle(head1);
output += "<br><br>";

// Case 2: With cycle
const six: ListNode = new ListNode(1);
const seven: ListNode = new ListNode(2);
const eight: ListNode = new ListNode(3);
const nine: ListNode = new ListNode(4);
const ten: ListNode = new ListNode(5);

six.next = seven;
seven.next = eight;
eight.next = nine;
nine.next = ten;
ten.next = eight;

const head2: ListNode = six;

output += "<b>Case 2 (With Cycle):</b><br>";
output += "1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle)<br><br>";

output += "<b>Has Cycle:</b><br>";
output += detectCycle(head2);

(document.getElementById("output") as HTMLElement).innerHTML = output;