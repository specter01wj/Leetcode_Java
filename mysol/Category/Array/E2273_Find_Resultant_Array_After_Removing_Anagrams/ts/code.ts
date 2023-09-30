
class Customer {
	name: string;

	constructor(name: string) {
		this.name = name;
	}

	announce() {
		return 'Hello, my name is: ' + this.name;
	}

}


let firstCustomer = new Customer('James');
let newMessage: string = firstCustomer.announce();

let webHeading = document.querySelector('h1');
webHeading.textContent = newMessage;


