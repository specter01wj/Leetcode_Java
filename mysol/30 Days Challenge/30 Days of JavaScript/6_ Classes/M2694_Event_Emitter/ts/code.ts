type Callback = (...args: any[]) => any;
type Subscription = {
    unsubscribe: () => void
}

class EventEmitter {
  private events: Record<string, Callback[]>;

  constructor() {
      this.events = {};
  }  

	subscribe(eventName: string, callback: Callback): Subscription {
		if (!this.events[eventName]) {
        this.events[eventName] = [];
    }

    this.events[eventName].push(callback);

		return {
			unsubscribe: () => {
				const index = this.events[eventName].indexOf(callback);
        if (index > -1) {
            this.events[eventName].splice(index, 1);
        }
			}
    };
	}

	emit(eventName: string, args: any[] = []): any[] {
		if (!this.events[eventName] || this.events[eventName].length === 0) {
        return [];
    }
    
    return this.events[eventName].map(callback => callback(...args));
	}
}


const emitter = new EventEmitter();

// Subscribe to the onClick event with onClickCallback
function onClickCallback() { return 99 }
const sub = emitter.subscribe('onClick', onClickCallback);

let input1 = '';
let output1 = emitter.emit('onClick'); // [99]
let output2 = sub.unsubscribe(); // undefined
let output3 = emitter.emit('onClick'); // []

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

let webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);



