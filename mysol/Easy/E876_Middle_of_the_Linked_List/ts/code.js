/**
 * Definition for singly-linked list.
 */
class ListNode {
    val;
    next;
    constructor(val, next) {
        this.val = val === undefined ? 0 : val;
        this.next = next === undefined ? null : next;
    }
}
function middleNode(head) {
    let slow = head;
    let fast = head;
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
function printList(head) {
    const values = [];
    while (head !== null) {
        values.push(head.val);
        head = head.next;
    }
    return values.join(" -> ");
}
const head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
const middle = middleNode(head);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: <pre>' + JSON.stringify(printList(head), null, 2) +
    '</pre>Result = <pre>' + JSON.stringify(printList(middle), null, 2) + '</pre>';
