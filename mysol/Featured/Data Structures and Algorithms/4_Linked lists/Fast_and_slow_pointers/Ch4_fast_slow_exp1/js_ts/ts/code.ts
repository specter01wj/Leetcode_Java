class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function getMiddle(head: ListNode): number {
  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  while (fast !== null && fast.next !== null) {
    slow = slow!.next;
    fast = fast.next.next;
  }

  return slow!.val;
}

(document.getElementById("title") as HTMLElement).innerText =
  "Fast & Slow Pointers - Middle Node (TS)";

// Build 1 -> 2 -> 3 -> 4 -> 5
const one: ListNode = new ListNode(1);
const two: ListNode = new ListNode(2);
const three: ListNode = new ListNode(3);
const four: ListNode = new ListNode(4);
const five: ListNode = new ListNode(5);

one.next = two;
two.next = three;
three.next = four;
four.next = five;

const head: ListNode = one;

let output: string = "";

output += "<b>Input:</b><br>";
let current: ListNode | null = head;
while (current !== null) {
  output += current.val;
  if (current.next !== null) {
    output += " -> ";
  }
  current = current.next;
}
output += "<br><br>";

const middle: number = getMiddle(head);

output += "<b>Middle value:</b><br>";
output += middle;

(document.getElementById("output") as HTMLElement).innerHTML = output;