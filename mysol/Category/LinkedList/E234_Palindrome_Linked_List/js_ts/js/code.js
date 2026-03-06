class ListNode {
  constructor(val, next = null) {
    this.val = val;
    this.next = next;
  }
}

function isPalindrome(head) {

  let slow = head;
  let fast = head;

  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  let prev = null;
  let curr = slow;

  while (curr !== null) {
    let nextNode = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  let left = head;
  let right = prev;

  while (right !== null) {
    if (left.val !== right.val) {
      return false;
    }
    left = left.next;
    right = right.next;
  }

  return true;
}

document.getElementById("title").innerText =
"234. Palindrome Linked List (JS)";

let output = "";

// Example 1
const a1 = new ListNode(1);
const a2 = new ListNode(2);
const a3 = new ListNode(2);
const a4 = new ListNode(1);

a1.next = a2;
a2.next = a3;
a3.next = a4;

const head1 = a1;

output += "<b>=== Example 1 ===</b><br>";
output += "<b>Input :</b> ";

let p1 = head1;
while (p1 !== null) {
  output += p1.val;
  if (p1.next !== null) output += " -> ";
  p1 = p1.next;
}

output += "<br>";

const result1 = isPalindrome(head1);

output += "<b>Output:</b> " + result1 + "<br><br>";


// Example 2
const b1 = new ListNode(1);
const b2 = new ListNode(2);

b1.next = b2;

const head2 = b1;

output += "<b>=== Example 2 ===</b><br>";
output += "<b>Input :</b> ";

let p2 = head2;
while (p2 !== null) {
  output += p2.val;
  if (p2.next !== null) output += " -> ";
  p2 = p2.next;
}

output += "<br>";

const result2 = isPalindrome(head2);

output += "<b>Output:</b> " + result2 + "<br>";

document.getElementById("output").innerHTML = output;