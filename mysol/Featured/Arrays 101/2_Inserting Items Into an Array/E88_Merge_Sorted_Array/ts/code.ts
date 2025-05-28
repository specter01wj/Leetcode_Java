function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let p1 = m - 1;
    let p2 = n - 1;
    let p = m + n - 1;

    while (p1 >= 0 && p2 >= 0) {
        if (nums1[p1] > nums2[p2]) {
            nums1[p] = nums1[p1];
            p1--;
        } else {
            nums1[p] = nums2[p2];
            p2--;
        }
        p--;
    }

    while (p2 >= 0) {
        nums1[p] = nums2[p2];
        p2--;
        p--;
    }
};

const nums1: number[] = [1,2,3,0,0,0], m: number = 3, nums2: number[] = [2,5,6], n: number = 3;
const inputCopy = [...nums1];
merge(inputCopy);
const results = inputCopy;

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + JSON.stringify(nums1, null, 2) + '; Input2: ' + JSON.stringify(nums2, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

