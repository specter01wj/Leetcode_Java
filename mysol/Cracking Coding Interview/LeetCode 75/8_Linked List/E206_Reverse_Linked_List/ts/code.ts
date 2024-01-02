function reverseList(head: ListNode | null): ListNode | null {
  let prev: ListNode | null = null;
  let current: ListNode | null = head;
  let next: ListNode | null = null;

  while (current !== null) {
      next = current.next;   // Save next node
      current.next = prev;   // Reverse the pointer
      prev = current;        // Move prev to current node
      current = next;        // Proceed to next node
  }

  return prev;  // prev is the new head of the reversed list
};

class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val===undefined ? 0 : val);
    this.next = (next===undefined ? null : next);
  }
}

function arrayToList(arr) {
  let head = new ListNode(0);
  let current = head;
  for (let val of arr) {
      current.next = new ListNode(val);
      current = current.next;
  }
  return head.next; // Return the actual head, not the dummy node
}

function listToArray(list) {
  let arr = [];
  while (list !== null) {
      arr.push(list.val);
      list = list.next;
  }
  return arr;
}

let input1 = [1,2,3,4,5];
let linkedListInput = arrayToList(input1);
let modifiedList = reverseList(linkedListInput);
let output1 = listToArray(modifiedList);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

