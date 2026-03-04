class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

// Implementation (submission-style only). No prints here.
function deleteDuplicates(head: ListNode | null): ListNode | null {

  const dummy: ListNode = new ListNode(0, head);

  let prev: ListNode = dummy;
  let curr: ListNode | null = head;

  while (curr !== null) {

    if (curr.next !== null && curr.val === curr.next.val) {

      const dupVal: number = curr.val;

      while (curr !== null && curr.val === dupVal) {
        curr = curr.next;
      }

      prev.next = curr;

    } else {

      prev = curr;
      curr = curr.next;
    }
  }

  return dummy.next;
}

(document.getElementById("title") as HTMLElement).innerText =
  "82. Remove Duplicates from Sorted List II (TS)";

let output: string = "";

// Example 1: head = [1,2,3,3,4,4,5]
const a1: ListNode = new ListNode(1);
const a2: ListNode = new ListNode(2);
const a3: ListNode = new ListNode(3);
const a4: ListNode = new ListNode(3);
const a5: ListNode = new ListNode(4);
const a6: ListNode = new ListNode(4);
const a7: ListNode = new ListNode(5);

a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
a5.next = a6;
a6.next = a7;

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

const result1: ListNode | null = deleteDuplicates(head1);

output += "<b>Output:</b> ";
let q1: ListNode | null = result1;
while (q1 !== null) {
  output += q1.val;
  if (q1.next !== null) output += " -> ";
  q1 = q1.next;
}
output += "<br><br>";


// Example 2: head = [1,1,1,2,3]
const b1: ListNode = new ListNode(1);
const b2: ListNode = new ListNode(1);
const b3: ListNode = new ListNode(1);
const b4: ListNode = new ListNode(2);
const b5: ListNode = new ListNode(3);

b1.next = b2;
b2.next = b3;
b3.next = b4;
b4.next = b5;

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

const result2: ListNode | null = deleteDuplicates(head2);

output += "<b>Output:</b> ";
let q2: ListNode | null = result2;
while (q2 !== null) {
  output += q2.val;
  if (q2.next !== null) output += " -> ";
  q2 = q2.next;
}
output += "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;