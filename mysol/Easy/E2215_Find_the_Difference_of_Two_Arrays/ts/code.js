function findDifference(nums1, nums2) {
    var set1 = new Set(nums1);
    var set2 = new Set(nums2);
    var result = [[], []];
    set1.forEach(function (num) {
        if (!set2.has(num)) {
            result[0].push(num);
        }
    });
    set2.forEach(function (num) {
        if (!set1.has(num)) {
            result[1].push(num);
        }
    });
    return result;
}
;
var nums1 = [1, 2, 3], nums2 = [2, 4, 6];
var output1 = findDifference(nums1, nums2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
