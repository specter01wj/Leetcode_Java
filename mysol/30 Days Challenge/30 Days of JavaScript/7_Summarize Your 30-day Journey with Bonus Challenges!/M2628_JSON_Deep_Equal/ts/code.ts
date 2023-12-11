type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function areDeeplyEqual(o1: JSONValue, o2: JSONValue): boolean {
	// Check for null values
    if (o1 === null || o2 === null) {
        return o1 === o2;
    }

    // Check if both values are of the same type
    if (typeof o1 !== typeof o2) {
        return false;
    }

    // Handle primitive types
    if (typeof o1 !== 'object' || o1 === null || o2 === null) {
        return o1 === o2;
    }

    // Differentiate between arrays and objects
    if (Array.isArray(o1) !== Array.isArray(o2)) {
        return false;
    }

    // Handle arrays
    if (Array.isArray(o1) && Array.isArray(o2)) {
        if (o1.length !== o2.length) {
            return false;
        }
        for (let i = 0; i < o1.length; i++) {
            if (!areDeeplyEqual(o1[i], o2[i])) {
                return false;
            }
        }
        return true;
    }

    // Handle objects
    const keys1 = Object.keys(o1 as object);
    const keys2 = Object.keys(o2 as object);

    if (keys1.length !== keys2.length) {
        return false;
    }

    for (let key of keys1) {
        if (!keys2.includes(key) || !areDeeplyEqual((o1 as { [key: string]: JSONValue })[key], (o2 as { [key: string]: JSONValue })[key])) {
            return false;
        }
    }

    return true;
};

let input = '';
const throttled = throttle((item) => {
  let output1 = item;
  let webHeading1 = document.querySelector('#t1');
  webHeading1.textContent = 'Output: ' + output1.toString();
}, 1000);
throttled("log"); // logged immediately.
throttled("log1000"); // logged at t=100ms.



