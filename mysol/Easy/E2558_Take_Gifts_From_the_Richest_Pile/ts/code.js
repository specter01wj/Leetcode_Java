function pickGifts(gifts, k) {
    // Helper function to heapify a subtree rooted at index i
    function heapify(arr, n, i) {
        let largest = i;
        let left = 2 * i + 1;
        let right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest !== i) {
            [arr[i], arr[largest]] = [arr[largest], arr[i]];
            heapify(arr, n, largest);
        }
    }
    // Function to build a max heap from an array
    function buildMaxHeap(arr) {
        const n = arr.length;
        for (let i = Math.floor(n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    // Function to extract the maximum element from the heap
    function extractMax(arr, n) {
        const max = arr[0];
        arr[0] = arr[n - 1];
        heapify(arr, n - 1, 0);
        return max;
    }
    let n = gifts.length;
    // Build the initial max heap
    buildMaxHeap(gifts);
    // Perform the operation for k seconds
    for (let i = 0; i < k; i++) {
        // Extract the largest pile
        const largestPile = extractMax(gifts, n);
        n--; // Reduce the size of the heap
        // Calculate the remaining gifts after taking the square root
        const remainingGifts = Math.floor(Math.sqrt(largestPile));
        gifts[n] = remainingGifts; // Add the remaining gifts back to the heap
        n++; // Increase the heap size again
        buildMaxHeap(gifts); // Rebuild the heap with the new element
    }
    // Sum up all the remaining gifts
    let totalRemainingGifts = 0;
    for (let i = 0; i < n; i++) {
        totalRemainingGifts += gifts[i];
    }
    return totalRemainingGifts;
}
const input = [25, 64, 9, 4, 100];
const k = 4;
const results = pickGifts(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
