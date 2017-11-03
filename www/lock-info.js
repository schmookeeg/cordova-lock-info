var exec = require("cordova/exec");

var lock = {};

lock.isLocked = function (successCallback, errorCallback) {
    exec(
        successCallback,
        errorCallback,
        'LockInfoPlugin',
        'isLocked',
        []
    );
}

lock.isScreen = function (successCallback, errorCallback) {
    exec(
        successCallback,
        errorCallback,
        'LockInfoPlugin',
        'isScreen',
        []
    );
}


module.exports.isLocked = lock;
