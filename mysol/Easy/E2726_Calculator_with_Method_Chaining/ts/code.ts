class Calculator {
  private result: number;

	constructor(value: number) {
		this.result = value;
  }
    
	add(value: number): Calculator {
		this.result += value;
    return this;
	}
    
	subtract(value: number): Calculator {
		this.result -= value;
    return this;
	}
    
	multiply(value: number): Calculator {
		this.result *= value;
    return this;
	}

	divide(value: number): Calculator {
		if (value === 0) {
      throw new Error("Division by zero is not allowed");
    }
    this.result /= value;
    return this;
	}
    
	power(value: number): Calculator {
		this.result **= value;
    return this;
	}

	getResult(): number {
		return this.result;
	}
}


let input1 = '';
let output1 = new Calculator(10).add(5).subtract(7).getResult(); // 10 + 5 - 7 = 8
let output2 = new Calculator(2).multiply(5).power(2).getResult(); // (2 * 5) ^ 2 = 100
// let output3 = new Calculator(20).divide(0).getResult(); // 20 / 0 

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

let webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);

// let webHeading3 = document.querySelector('#t3');
// webHeading3.textContent = 'Output: ' + JSON.stringify(output3);



