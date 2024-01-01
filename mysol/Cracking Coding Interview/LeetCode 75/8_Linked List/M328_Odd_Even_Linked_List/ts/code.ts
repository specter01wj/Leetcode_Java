function oddEvenList(head: ListNode | null): ListNode | null {
  if (head === null) return null;

  let odd: ListNode = head;
  let even: ListNode = head.next;
  let evenHead: ListNode = even;

  while (even !== null && even.next !== null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
  }

  odd.next = evenHead;
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

let input1 = [1,2,3,4,5];
let linkedListInput = arrayToList(input1);
let modifiedList = oddEvenList(linkedListInput);
let output1 = listToArray(modifiedList);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

