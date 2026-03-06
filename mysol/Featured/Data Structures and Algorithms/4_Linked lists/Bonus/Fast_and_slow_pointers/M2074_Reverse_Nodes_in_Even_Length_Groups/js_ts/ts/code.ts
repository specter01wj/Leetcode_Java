class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function reverseEvenLengthGroups(head: ListNode | null): ListNode | null {

  let current: ListNode | null = head;
  let prevGroupEnd: ListNode | null = null;

  let groupSize: number = 1;

  while (current !== null) {

    let groupStart: ListNode | null = current;

    let temp: ListNode | null = current;
    let count: number = 0;

    while (temp !== null && count < groupSize) {
      temp = temp.next;
      count++;
    }

    if (count % 2 === 0) {

      let prev: ListNode | null = temp;
      let node: ListNode | null = groupStart;

      for (let i = 0; i < count; i++) {
        let nextNode: ListNode | null = node!.next;
        node!.next = prev;
        prev = node;
        node = nextNode;
      }

      if (prevGroupEnd !== null) {
        prevGroupEnd.next = prev;
      } else {
        head = prev;
      }

      prevGroupEnd = groupStart;
      current = temp;

    } else {

      for (let i = 0; i < count; i++) {
        prevGroupEnd = current;
        current = current!.next;
      }

    }

    groupSize++;
  }

  return head;
}

(document.getElementById("title") as HTMLElement).innerText =
"2074. Reverse Nodes in Even Length Groups (TS)";

let output: string = "";

// Example 1: head = [5,2,6,3,9,1,7,3,8,4]
const a1: ListNode = new ListNode(5);
const a2: ListNode = new ListNode(2);
const a3: ListNode = new ListNode(6);
const a4: ListNode = new ListNode(3);
const a5: ListNode = new ListNode(9);
const a6: ListNode = new ListNode(1);
const a7: ListNode = new ListNode(7);
const a8: ListNode = new ListNode(3);
const a9: ListNode = new ListNode(8);
const a10: ListNode = new ListNode(4);

a1.next = a2;
a2.next = a3;
a3.next = a4;
a4.next = a5;
a5.next = a6;
a6.next = a7;
a7.next = a8;
a8.next = a9;
a9.next = a10;

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

const result1: ListNode | null = reverseEvenLengthGroups(head1);

output += "<b>Output:</b> ";

let r1: ListNode | null = result1;
while (r1 !== null) {
  output += r1.val;
  if (r1.next !== null) output += " -> ";
  r1 = r1.next;
}

output += "<br><br>";


// Example 2: head = [1,1,0,6]
const b1: ListNode = new ListNode(1);
const b2: ListNode = new ListNode(1);
const b3: ListNode = new ListNode(0);
const b4: ListNode = new ListNode(6);

b1.next = b2;
b2.next = b3;
b3.next = b4;

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

const result2: ListNode | null = reverseEvenLengthGroups(head2);

output += "<b>Output:</b> ";

let r2: ListNode | null = result2;
while (r2 !== null) {
  output += r2.val;
  if (r2.next !== null) output += " -> ";
  r2 = r2.next;
}

output += "<br><br>";


// Example 3: head = [1,1,0,6,5]
const c1: ListNode = new ListNode(1);
const c2: ListNode = new ListNode(1);
const c3: ListNode = new ListNode(0);
const c4: ListNode = new ListNode(6);
const c5: ListNode = new ListNode(5);

c1.next = c2;
c2.next = c3;
c3.next = c4;
c4.next = c5;

const head3: ListNode = c1;

output += "<b>=== Example 3 ===</b><br>";
output += "<b>Input :</b> ";

let p3: ListNode | null = head3;
while (p3 !== null) {
  output += p3.val;
  if (p3.next !== null) output += " -> ";
  p3 = p3.next;
}

output += "<br>";

const result3: ListNode | null = reverseEvenLengthGroups(head3);

output += "<b>Output:</b> ";

let r3: ListNode | null = result3;
while (r3 !== null) {
  output += r3.val;
  if (r3.next !== null) output += " -> ";
  r3 = r3.next;
}

(document.getElementById("output") as HTMLElement).innerHTML = output;