
class MovingAverage {
  private size: number;
  private queue: number[];
  private sum: number;

  constructor(size: number) {
      this.size = size;
      this.queue = [];
      this.sum = 0;
  }

  next(val: number): number {
      if (this.queue.length === this.size) {
          this.sum -= this.queue.shift()!;
      }
      this.queue.push(val);
      this.sum += val;
      return this.sum / this.queue.length;
  }

  toString(): string {
    const obj = {
        size: this.size,
        queue: this.queue,
        sum: this.sum
    };
    return JSON.stringify(obj);
}
}

const obj = new MovingAverage(3);
obj.next(1);  // return 1.0
obj.next(10); // return 5.5
obj.next(3);  // return 4.66667
obj.next(5);  // return 6.0

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Output: ' + obj.toString() + 
'<br>Result = ' + obj.next(1) + ', ' + (obj.next(10)) + ', ' + obj.next(3) + ', ' + obj.next(5);

