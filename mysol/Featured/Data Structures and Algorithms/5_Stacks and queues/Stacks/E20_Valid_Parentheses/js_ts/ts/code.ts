class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function swapPairs(head: ListNode | null): ListNode | null {

  if (head === null || head.next === null) {
    return head;
  }

  let dummy: ListNode = head.next;
  let prev: ListNode | null = null;

  while (head !== null && head.next !== null) {

    if (prev !== null) {
      prev.next = head.next;
    }

    prev = head;

    const nextNode: ListNode | null = head.next.next;
    head.next.next = head;

    head.next = nextNode;
    head = nextNode;
  }

  return dummy;
}

(document.getElementById("title") as HTMLElement).innerText =
  "24. Swap Nodes in Pairs (TS)";

let output: string = "";

// Example 1: head = [1,2,3,4]
const one: ListNode = new ListNode(1);
const two: ListNode = new ListNode(2);
const three: ListNode = new ListNode(3);
const four: ListNode = new ListNode(4);

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

const result1: ListNode | null = swapPairs(head1);

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

// Example 2: head = []
const head2: ListNode | null = null;

output += "<b>Example 2 Input:</b><br>[]<br><br>";

const result2: ListNode | null = swapPairs(head2);

output += "<b>Example 2 Output:</b><br>";
if (result2 === null) {
  output += "[]";
} else {
  let out2: ListNode | null = result2;
  while (out2 !== null) {
    output += out2.val;
    if (out2.next !== null) {
      output += " -> ";
    }
    out2 = out2.next;
  }
}
output += "<br><br>";

// Example 3: head = [1]
const head3: ListNode = new ListNode(1);

output += "<b>Example 3 Input:</b><br>1<br><br>";

const result3: ListNode | null = swapPairs(head3);

output += "<b>Example 3 Output:</b><br>";
let out3: ListNode | null = result3;
while (out3 !== null) {
  output += out3.val;
  if (out3.next !== null) {
    output += " -> ";
  }
  out3 = out3.next;
}
output += "<br><br>";

// Example 4: head = [1,2,3]
const a: ListNode = new ListNode(1);
const b: ListNode = new ListNode(2);
const c: ListNode = new ListNode(3);

a.next = b;
b.next = c;

const head4: ListNode = a;

output += "<b>Example 4 Input:</b><br>";
let current4: ListNode | null = head4;
while (current4 !== null) {
  output += current4.val;
  if (current4.next !== null) {
    output += " -> ";
  }
  current4 = current4.next;
}
output += "<br><br>";

const result4: ListNode | null = swapPairs(head4);

output += "<b>Example 4 Output:</b><br>";
let out4: ListNode | null = result4;
while (out4 !== null) {
  output += out4.val;
  if (out4.next !== null) {
    output += " -> ";
  }
  out4 = out4.next;
}

(document.getElementById("output") as HTMLElement).innerHTML = output;