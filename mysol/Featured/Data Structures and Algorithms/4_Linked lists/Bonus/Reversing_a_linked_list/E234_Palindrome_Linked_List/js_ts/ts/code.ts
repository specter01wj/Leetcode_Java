class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function isPalindrome(head: ListNode | null): boolean {

  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  while (fast !== null && fast.next !== null) {
    slow = slow!.next;
    fast = fast.next.next;
  }

  let prev: ListNode | null = null;
  let curr: ListNode | null = slow;

  while (curr !== null) {
    let nextNode: ListNode | null = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  let left: ListNode | null = head;
  let right: ListNode | null = prev;

  while (right !== null) {
    if (left!.val !== right.val) {
      return false;
    }
    left = left!.next;
    right = right.next;
  }

  return true;
}

(document.getElementById("title") as HTMLElement).innerText =
"234. Palindrome Linked List (TS)";

let output: string = "";

// Example 1
const a1: ListNode = new ListNode(1);
const a2: ListNode = new ListNode(2);
const a3: ListNode = new ListNode(2);
const a4: ListNode = new ListNode(1);

a1.next = a2;
a2.next = a3;
a3.next = a4;

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

const result1: boolean = isPalindrome(head1);

output += "<b>Output:</b> " + result1 + "<br><br>";


// Example 2
const b1: ListNode = new ListNode(1);
const b2: ListNode = new ListNode(2);

b1.next = b2;

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

const result2: boolean = isPalindrome(head2);

output += "<b>Output:</b> " + result2 + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;