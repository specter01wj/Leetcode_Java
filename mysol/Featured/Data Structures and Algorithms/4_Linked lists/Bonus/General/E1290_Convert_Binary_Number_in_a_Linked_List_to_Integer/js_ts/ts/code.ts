class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function getDecimalValue(head: ListNode | null): number {

  let result: number = 0;

  while (head !== null) {
    result = result * 2 + head.val;
    head = head.next;
  }

  return result;
}

(document.getElementById("title") as HTMLElement).innerText =
"1290. Convert Binary Number in a Linked List to Integer (TS)";

let output: string = "";

// Example 1: head = [1,0,1]
const a1: ListNode = new ListNode(1);
const a2: ListNode = new ListNode(0);
const a3: ListNode = new ListNode(1);

a1.next = a2;
a2.next = a3;

const head1: ListNode = a1;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";
let p1: ListNode | null = head1;
while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}
output += "<br>";

const result1: number = getDecimalValue(head1);

output += "<b>Output:</b> " + result1 + "<br><br>";


// Example 2: head = [0]
const b1: ListNode = new ListNode(0);

const head2: ListNode = b1;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";
let p2: ListNode | null = head2;
while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}
output += "<br>";

const result2: number = getDecimalValue(head2);

output += "<b>Output:</b> " + result2;

(document.getElementById("output") as HTMLElement).innerHTML = output;