class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function findNode(head: ListNode, k: number): ListNode {
  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  for (let i: number = 0; i < k; i++) {
    fast = fast!.next;
  }

  while (fast !== null) {
    slow = slow!.next;
    fast = fast.next;
  }

  return slow!;
}

(document.getElementById("title") as HTMLElement).innerText =
  "Kth Node From End (TS)";

let output: string = "";

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
const k: number = 2;

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

output += "<b>k:</b><br>";
output += k + "<br><br>";

const result: ListNode = findNode(head, k);

output += "<b>kth node from end:</b><br>";
output += result.val;

(document.getElementById("output") as HTMLElement).innerHTML = output;