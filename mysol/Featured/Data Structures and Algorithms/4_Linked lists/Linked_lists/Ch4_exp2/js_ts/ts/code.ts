/*
 * Chapter 4 – Linked Lists
 *
 * Example 1: Create and Traverse a Singly Linked List
 */

class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function createLinkedList(): ListNode {

  const one: ListNode = new ListNode(1);
  const two: ListNode = new ListNode(2);
  const three: ListNode = new ListNode(3);

  // Link nodes: 1 → 2 → 3 → null
  one.next = two;
  two.next = three;

  return one; // head
}

function traverseLinkedList(head: ListNode | null): number[] {

  const values: number[] = [];
  let current: ListNode | null = head;

  while (current !== null) {
    values.push(current.val);
    current = current.next;
  }

  return values;
}


/* ===============================
   Testing Section
=============================== */

const head: ListNode = createLinkedList();

const result: number[] = traverseLinkedList(head);

let output: string = "<h2>>> Chapter 4 – Linked List: Create & Traverse</h2>";

output += "<b>Structure:</b><br>1 → 2 → 3 → null<br><br>";
output += "<b>Traversal Output:</b><br>" + result.join(" → ");

(document.querySelector('#t1') as HTMLElement).innerHTML = output;