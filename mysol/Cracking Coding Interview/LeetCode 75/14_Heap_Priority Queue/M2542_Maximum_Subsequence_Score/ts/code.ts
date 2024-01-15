function maxScore(nums1: number[], nums2: number[], k: number): number {
  let result: number = 0;
  let totalSum: number = 0;
  let heap: MinPriorityQueue<number> = new MinPriorityQueue<number>();

  const merged: [number, number][] = nums1.map((nums1Val, i) => [nums2[i], nums1Val]);
  merged.sort((a, b) => b[0] - a[0]);

  for (const [maxOf2, num1Val] of merged) {
      if (heap.size === k) {
          totalSum -= heap.dequeue();
      }

      totalSum += num1Val;
      heap.enqueue(num1Val);

      if (heap.size === k) {
          result = Math.max(result, totalSum * maxOf2);
      }
  }

  return result;
}

class MinPriorityQueue<T> {
  private heap: T[];
  private comparator: (a: T, b: T) => number;

  constructor(comparator: (a: T, b: T) => number = (a, b) => a as any - b as any) {
      this.heap = [];
      this.comparator = comparator;
  }

  get size(): number {
      return this.heap.length;
  }

  enqueue(value: T): void {
      this.heap.push(value);
      this.heap.sort(this.comparator);
  }

  dequeue(): T | undefined {
      return this.heap.shift();
  }

  peek(): T | undefined {
      return this.heap[0];
  }
}

let input1 = [1,3,3,2], input2 = [2,1,3,4];
let k = 3;
let output1 = maxScore(input1, input2, k);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

