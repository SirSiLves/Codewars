/*
*
*
*   Lost number in number sequence
*   https://www.codewars.com/kata/595aa94353e43a8746000120
*
* */


function findDeletedNumber(arr, mixArr) {
    mixArr = mixArr.sort(function (n1, n2) {
        return n1 - n2;
    });

    let missedNumber = 0;
    for (let i = 0; i < arr.length; i++) {

        if ((arr[i] ^ i) !== (mixArr[i] ^ i)) {
            console.log(arr[i])
            missedNumber = arr[i];
            break;
        }
    }

    return missedNumber;
}


function findDeletedNumber2(a, b) {
    // return arr.reduce((a, v) => a ^ v, 0) ^ mixArr.reduce((a, v) => a ^ v, 0);
    return [...a, ...b].reduce(function (n1, n2) {
        return n1 ^ n2;
    });
}


findDeletedNumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14], [1, 9, 14, 7, 13, 4, 6, 2, 3, 8, 10, 11, 12]);
