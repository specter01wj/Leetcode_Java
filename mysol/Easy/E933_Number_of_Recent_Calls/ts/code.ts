class RecentCounter {
  private requests: number[];

  constructor() {
      this.requests = [];
  }

  ping(t: number): number {
      this.requests.push(t);

      // Remove older requests outside the 3000ms window
      while (this.requests.length > 0 && this.requests[0] < t - 3000) {
          this.requests.shift();
      }

      // Return the number of requests in the window
      return this.requests.length;
  }
}

var obj = new RecentCounter();
let input1 = 100;
let param_1 = obj.ping(input1);

// let output1 = decodeString(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(param_1);

