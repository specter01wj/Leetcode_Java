function promiseAll(functions) {
    return new Promise(function (resolve, reject) {
        var results = new Array(functions.length);
        var completed = 0;
        var hasRejected = false;
        if (functions.length === 0) {
            resolve(results);
        }
        functions.forEach(function (func, index) {
            func()
                .then(function (result) {
                if (hasRejected)
                    return;
                results[index] = result;
                completed += 1;
                if (completed === functions.length) {
                    resolve(results);
                }
            })
                .catch(function (error) {
                if (!hasRejected) {
                    hasRejected = true;
                    reject(error);
                }
            });
        });
    });
}
;
var output = '';
var promise = promiseAll([function () { return new Promise(function (res) { return res(42); }); }]);
promise.then(function (item) {
    output = item;
    var webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + (output);
}); // [42]
