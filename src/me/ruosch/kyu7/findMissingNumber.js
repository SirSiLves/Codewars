/*
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
    return [...a, ...b].reduce((c,d) => c ^ d, 0);
}


// findDeletedNumber([1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 9, 7, 4, 6, 2, 3, 8]);
findDeletedNumber([1, 2, 3, 4, 5, 6, 7, 8, 9], [1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 26, 27, 28, 29, 3, 30, 31, 32, 33, 4, 5, 6, 7, 8, 9]);
