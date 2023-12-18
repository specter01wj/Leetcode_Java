var EventEmitter = /** @class */ (function () {
    function EventEmitter() {
        this.events = {};
    }
    EventEmitter.prototype.subscribe = function (eventName, callback) {
        var _this = this;
        if (!this.events[eventName]) {
            this.events[eventName] = [];
        }
        this.events[eventName].push(callback);
        return {
            unsubscribe: function () {
                var index = _this.events[eventName].indexOf(callback);
                if (index > -1) {
                    _this.events[eventName].splice(index, 1);
                }
            }
        };
    };
    EventEmitter.prototype.emit = function (eventName, args) {
        if (args === void 0) { args = []; }
        if (!this.events[eventName] || this.events[eventName].length === 0) {
            return [];
        }
        return this.events[eventName].map(function (callback) { return callback.apply(void 0, args); });
    };
    return EventEmitter;
}());
var emitter = new EventEmitter();
// Subscribe to the onClick event with onClickCallback
function onClickCallback() { return 99; }
var sub = emitter.subscribe('onClick', onClickCallback);
var input1 = '';
var output1 = emitter.emit('onClick'); // [99]
var output2 = sub.unsubscribe(); // undefined
var output3 = emitter.emit('onClick'); // []
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
