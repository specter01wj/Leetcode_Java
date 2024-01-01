function deleteMiddle(head: ListNode | null): ListNode | null {
  if (head === null || head.next === null) {
      return null;
  }

  let prev: ListNode | null = null;
  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  while (fast !== null && fast.next !== null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
  }

  // Delete the middle node
  if (prev !== null && slow !== null) {
      prev.next = slow.next;
  }

  return head;
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

let input1 = [1,3,4,7,1,2,6];
let linkedListInput = arrayToList(input1);
let modifiedList = deleteMiddle(linkedListInput);
let output1 = listToArray(modifiedList);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

