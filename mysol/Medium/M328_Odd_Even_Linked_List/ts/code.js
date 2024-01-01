function oddEvenList(head) {
    if (head === null)
        return null;
    var odd = head;
    var even = head.next;
    var evenHead = even;
    while (even !== null && even.next !== null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
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
var input1 = [1, 2, 3, 4, 5];
var linkedListInput = arrayToList(input1);
var modifiedList = oddEvenList(linkedListInput);
var output1 = listToArray(modifiedList);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
