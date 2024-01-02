function pairSum(head: ListNode | null): number {
  // Function to reverse a linked list
  function reverseList(node: ListNode | null): ListNode | null {
      let prev: ListNode | null = null;
      let current: ListNode | null = node;
      let next: ListNode | null = null;

      while (current !== null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      return prev;
  }

  // Find the middle of the list
  let slow: ListNode | null = head, fast: ListNode | null = head;
  while (fast !== null && fast.next !== null) {
      slow = slow.next;
      fast = fast.next.next;
  }

  // Reverse the second half
  let secondHalf: ListNode | null = reverseList(slow);
  let firstHalf: ListNode | null = head;

  // Calculate the twin sums and find the maximum
  let maxSum: number = 0;
  while (secondHalf !== null) {
      maxSum = Math.max(maxSum, firstHalf!.val + secondHalf.val);
      firstHalf = firstHalf!.next;
      secondHalf = secondHalf.next;
  }

  return maxSum;
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
let output1 = pairSum(linkedListInput);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

