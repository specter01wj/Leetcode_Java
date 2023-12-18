var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
function join(arr1, arr2) {
    var mergedObjects = new Map();
    var mergeObjects = function (obj1, obj2) {
        for (var key in obj2) {
            obj1[key] = obj2[key];
        }
        return obj1;
    };
    [arr1, arr2].forEach(function (array) {
        array.forEach(function (item) {
            if (typeof item === 'object' && item !== null && 'id' in item) {
                var obj = item;
                var id = obj.id;
                if (mergedObjects.has(id)) {
                    mergedObjects.set(id, mergeObjects(mergedObjects.get(id), obj));
                }
                else {
                    mergedObjects.set(id, __assign({}, obj));
                }
            }
        });
    });
    return Array.from(mergedObjects.values()).sort(function (a, b) { return a.id - b.id; });
}
;
var input1 = [{ "id": 1, "x": 1 }, { "id": 2, "x": 9 }], arr1 = [{ "id": 3, "x": 5 }];
var input2 = [{ "id": 1, "x": 2, "y": 3 }, { "id": 2, "x": 3, "y": 6 }], arr2 = [{ "id": 2, "x": 10, "y": 20 }, { "id": 3, "x": 0, "y": 0 }];
var input3 = [{ "id": 1, "b": { "b": 94 }, "v": [4, 3], "y": 48 }], arr3 = [{ "id": 1, "b": { "c": 84 }, "v": [1, 3] }];
var output1 = join(input1, arr1);
var output2 = join(input2, arr2);
var output3 = join(input3, arr3);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
var webHeading3 = document.querySelector('#t3');
webHeading3.textContent = 'Output: ' + JSON.stringify(output3);
