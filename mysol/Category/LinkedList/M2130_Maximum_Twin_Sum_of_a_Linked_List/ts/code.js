function pairSum(head) {
    // Function to reverse a linked list
    function reverseList(node) {
        var prev = null;
        var current = node;
        var next = null;
        while (current !== null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    // Find the middle of the list
    var slow = head, fast = head;
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    // Reverse the second half
    var secondHalf = reverseList(slow);
    var firstHalf = head;
    // Calculate the twin sums and find the maximum
    var maxSum = 0;
    while (secondHalf !== null) {
        maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }
    return maxSum;
}
;
var ListNode = /** @class */ (function () {
    function ListNode(val, next) {
        this.val = (val === undefined ? 0 : val);
        this.next = (next === undefined ? null : next);
    }
    return ListNode;
}());
function arrayToList(arr) {
    var head = new ListNode(0);
    var current = head;
    for (var _i = 0, arr_1 = arr; _i < arr_1.length; _i++) {
        var val = arr_1[_i];
        current.next = new ListNode(val);
        current = current.next;
    }
    return head.next; // Return the actual head, not the dummy node
}
function listToArray(list) {
    var arr = [];
    while (list !== null) {
        arr.push(list.val);
        list = list.next;
    }
    return arr;
}
var input1 = [1, 2, 3, 4, 5];
var linkedListInput = arrayToList(input1);
var output1 = pairSum(linkedListInput);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
