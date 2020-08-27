
/*
*
*   Moving Zeros To The End
*   https://www.codewars.com/kata/52597aa56021e91c93000cb0
*
* */


var moveZeros = function (arr) {
    let newArr = [];
    let count = 0;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === 0) count++;
        else newArr.push(arr[i]);
    }

    for (let j = 0; j < count; j++) newArr.push(0);

    return newArr;
}


console.log(moveZeros([1, 2, 0, 1, 0, 1, 0, 3, 0, 1]));


var moveZeros2 = function (arr) {
    let filtedList = arr.filter(function (num) {
        return num !== 0;
    });
    let zeroList = arr.filter(function (num) {
        return num === 0;
    });
    return filtedList.concat(zeroList);
}

console.log(moveZeros2([1, 2, 0, 1, 0, 1, 0, 3, 0, 1]));
