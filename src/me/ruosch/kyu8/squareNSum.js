/*
*
*
*   Square(n) Sum
*   https://www.codewars.com/kata/515e271a311df0350d00000f/train/javascript
*
* */

function squareSum(numbers){

    let sum = 0;
    numbers.forEach((a) => {
        sum += a * a;
    });

    return sum;
}


console.log(squareSum([1,2]));
console.log(squareSum([0, 3, 4, 5]));



function squareSum2(numbers){
    return numbers.reduce((sum,num) => sum + (num * num), 0);
}
