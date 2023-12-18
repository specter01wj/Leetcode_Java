class TimeLimitedCache {
  private cache: Record<number, number>;
  private expiryTimes: Record<number, number>;

  constructor() {
      this.cache = {};
      this.expiryTimes = {};
  }
  
  set(key: number, value: number, duration: number): boolean {
      const now = new Date().getTime();
      const alreadyExistsAndUnexpired = this.cache.hasOwnProperty(key) && now < this.expiryTimes[key];

      this.cache[key] = value;
      this.expiryTimes[key] = now + duration;

      return alreadyExistsAndUnexpired;
  }

  get(key: number): number {
      const now = new Date().getTime();
      if (this.cache.hasOwnProperty(key) && now < this.expiryTimes[key]) {
          return this.cache[key];
      }
      return -1;
  }

  count(): number {
      const now = new Date().getTime();
      return Object.keys(this.expiryTimes).reduce((count, key) => {
          const numericKey = parseInt(key);
          if (now < this.expiryTimes[numericKey]) {
              count++;
          }
          return count;
      }, 0);
  }
}

const timeLimitedCache = new TimeLimitedCache()
let output1 = timeLimitedCache.set(1, 42, 1000); // false
let output2 = timeLimitedCache.get(1) // 42
let output3 = timeLimitedCache.count() // 1

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + (output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + (output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + (output3);



