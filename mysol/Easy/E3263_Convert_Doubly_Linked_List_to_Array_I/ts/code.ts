class _Node {
  val: number;
  prev: _Node | null;
  next: _Node | null;

  constructor(val?: number, prev?: _Node | null, next?: _Node | null) {
      this.val = val === undefined ? 0 : val;
      this.prev = prev === undefined ? null : prev;
      this.next = next === undefined ? null : next;
  }
}

function toArray(head: _Node | null): number[] {
  let result: number[] = [];
  let current: _Node | null = head;

  while (current !== null) {
      result.push(current.val);
      current = current.next;
  }

  return result;
};

function createDoublyLinkedList(arr: number[]): _Node | null {
  if (arr.length === 0) return null;

  let head = new _Node(arr[0]);
  let current = head;

  for (let i = 1; i < arr.length; i++) {
      let newNode = new _Node(arr[i], current, null);
      current.next = newNode;
      current = newNode;
  }

  return head;
}

const input: number[] = [1, 2, 3, 4, 3, 2, 1];
let head: _Node | null = createDoublyLinkedList(input);
const results: number[] = toArray(head);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

