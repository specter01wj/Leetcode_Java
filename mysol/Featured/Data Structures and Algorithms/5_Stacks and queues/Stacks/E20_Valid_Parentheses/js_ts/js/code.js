class ListNode {
  constructor(val, next = null) {
    this.val = val;
    this.next = next;
  }
}

function swapPairs(head) {

  if (head === null || head.next === null) {
    return head;
  }

  let dummy = head.next;
  let prev = null;

  while (head !== null && head.next !== null) {

    if (prev !== null) {
      prev.next = head.next;
    }

    prev = head;

    const nextNode = head.next.next;
    head.next.next = head;

    head.next = nextNode;
    head = nextNode;
  }

  return dummy;
}

document.getElementById("title").innerText =
  "24. Swap Nodes in Pairs (JS)";

let output = "";

// Example 1: head = [1,2,3,4]
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);

one.next = two;
two.next = three;
three.next = four;

const head1 = one;

output += "<b>Example 1 Input:</b><br>";
let current1 = head1;
while (current1 !== null) {
  output += current1.val;
  if (current1.next !== null) {
    output += " -> ";
  }
  current1 = current1.next;
}
output += "<br><br>";

const result1 = swapPairs(head1);

output += "<b>Example 1 Output:</b><br>";
let out1 = result1;
while (out1 !== null) {
  output += out1.val;
  if (out1.next !== null) {
    output += " -> ";
  }
  out1 = out1.next;
}
output += "<br><br>";

// Example 2: head = []
const head2 = null;

output += "<b>Example 2 Input:</b><br>[]<br><br>";

const result2 = swapPairs(head2);

output += "<b>Example 2 Output:</b><br>";
if (result2 === null) {
  output += "[]";
} else {
  let out2 = result2;
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
const head3 = new ListNode(1);

output += "<b>Example 3 Input:</b><br>1<br><br>";

const result3 = swapPairs(head3);

output += "<b>Example 3 Output:</b><br>";
let out3 = result3;
while (out3 !== null) {
  output += out3.val;
  if (out3.next !== null) {
    output += " -> ";
  }
  out3 = out3.next;
}
output += "<br><br>";

// Example 4: head = [1,2,3]
const a = new ListNode(1);
const b = new ListNode(2);
const c = new ListNode(3);

a.next = b;
b.next = c;

const head4 = a;

output += "<b>Example 4 Input:</b><br>";
let current4 = head4;
while (current4 !== null) {
  output += current4.val;
  if (current4.next !== null) {
    output += " -> ";
  }
  current4 = current4.next;
}
output += "<br><br>";

const result4 = swapPairs(head4);

output += "<b>Example 4 Output:</b><br>";
let out4 = result4;
while (out4 !== null) {
  output += out4.val;
  if (out4.next !== null) {
    output += " -> ";
  }
  out4 = out4.next;
}

document.getElementById("output").innerHTML = output;