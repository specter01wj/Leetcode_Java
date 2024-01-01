function deleteMiddle(head) {
    if (head === null || head.next === null) {
        return null;
    }
    var prev = null;
    var slow = head;
    var fast = head;
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
var input1 = [1, 3, 4, 7, 1, 2, 6];
var linkedListInput = arrayToList(input1);
var modifiedList = deleteMiddle(linkedListInput);
var output1 = listToArray(modifiedList);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
