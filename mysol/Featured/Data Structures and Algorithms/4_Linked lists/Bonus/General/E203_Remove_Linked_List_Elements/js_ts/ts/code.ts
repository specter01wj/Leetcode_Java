class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function removeElements(head: ListNode | null, val: number): ListNode | null {

  const dummy: ListNode = new ListNode(0);
  dummy.next = head;

  let current: ListNode = dummy;

  while (current.next !== null) {
    if (current.next.val === val) {
      current.next = current.next.next;
    } else {
      current = current.next;
    }
  }

  return dummy.next;
}

(document.getElementById("title") as HTMLElement).innerText =
"203. Remove Linked List Elements (TS)";

let output: string = "";

// Example 1: head = [1,2,6,3,4,5,6], val = 6
const a1: ListNode = new ListNode(1);
const a2: ListNode = new ListNode(2);
const a3: ListNode = new ListNode(6);
const a4: ListNode = new ListNode(3);
const a5: ListNode = new ListNode(4);
const a6: ListNode = new ListNode(5);
const a7: ListNode = new ListNode(6);

a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
a5.next = a6;
a6.next = a7;

const head1: ListNode = a1;
const val1: number = 6;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";
let p1: ListNode | null = head1;
while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}
output += "<br>";
output += "val = " + val1 + "<br>";

const result1: ListNode | null = removeElements(head1, val1);

output += "<b>Output:</b> ";
let q1: ListNode | null = result1;
while (q1 !== null) {
  output += q1.val;
  if (q1.next !== null) output += " -> ";
  q1 = q1.next;
}
output += "<br><br>";


// Example 2: head = [], val = 1
const head2: ListNode | null = null;
const val2: number = 1;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";
let p2: ListNode | null = head2;
while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}
output += "<br>";
output += "val = " + val2 + "<br>";

const result2: ListNode | null = removeElements(head2, val2);

output += "<b>Output:</b> ";
let q2: ListNode | null = result2;
while (q2 !== null) {
  output += q2.val;
  if (q2.next !== null) output += " -> ";
  q2 = q2.next;
}
output += "<br><br>";


// Example 3: head = [7,7,7,7], val = 7
const c1: ListNode = new ListNode(7);
const c2: ListNode = new ListNode(7);
const c3: ListNode = new ListNode(7);
const c4: ListNode = new ListNode(7);

c1.next = c2;
c2.next = c3;
c3.next = c4;

const head3: ListNode = c1;
const val3: number = 7;

output += "<b>=== Example 3 ===</b><br>";
output += "<b>Input :</b> ";
let p3: ListNode | null = head3;
while (p3 !== null) {
  output += p3.val;
  if (p3.next !== null) output += " -> ";
  p3 = p3.next;
}
output += "<br>";
output += "val = " + val3 + "<br>";

const result3: ListNode | null = removeElements(head3, val3);

output += "<b>Output:</b> ";
let q3: ListNode | null = result3;
while (q3 !== null) {
  output += q3.val;
  if (q3.next !== null) output += " -> ";
  q3 = q3.next;
}
output += "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;