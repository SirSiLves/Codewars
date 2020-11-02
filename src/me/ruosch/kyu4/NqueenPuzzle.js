/*
*
*
*   N queens puzzle (with one mandatory queen position)
*   https://www.codewars.com/kata/561bed6a31daa8df7400000e/train/javascript
*
* */

function queens(position, size) {
    const board = createBoard(size);
    const queen1 = getIndexValue(position)

    setQueen(queen1, board);

    for(let i = 0; i < size; i++) {



    }


    return "a1";
}

function setQueen(position, board) {

    for(let i = 0; i < board.length; i++) {
        for(let j = 0; j < board.length; j++) {

            if(position[0] === i && position[1] === j) {
                board[i][j] = 1;
            }
        }
    }

    console.log("SET QUEEEN");
    console.log(board);
}

function getIndexValue(position) {
    const xLine = ['a','b','c','d','e','f','g','h','i','j'];
    const yLine = ['1','2','3','4','5','6','7','8','9','0'];

    const x = position.substr(0,1);
    const y = position.substr(1,2);

    const xIndex = xLine.indexOf(x);
    const yIndex = yLine.indexOf(y);

    console.log("QUEEN POSITION:");
    console.log([xIndex,yIndex]);

    return [xIndex,yIndex];
}

function createBoard(size){
    const board = [];

    for(let i = 0; i < size; i++){
        const tempBoard = [];

        for(let j = 0; j < size; j++) {
            tempBoard.push(0);
        }

        board.push(tempBoard);
    }

    console.log("BOARD:");
    console.log(board);

    return board;
}






console.log(queens("b4", 4))
