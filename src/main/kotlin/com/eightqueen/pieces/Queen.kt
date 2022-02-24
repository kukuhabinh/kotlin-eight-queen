package com.eightqueen.pieces

import com.eightqueen.board.Position
import com.eightqueen.board.toFile
import com.eightqueen.board.toRank

data class Queen(val position: Position) {
    fun eatableInColumn(): List<Position> {
        var result: MutableList<Position> = mutableListOf();
        for (file in 1..8) {
            if (file.toFile() != this.position.file)
                result.add(Position(rank = position.rank, file = file.toFile()))
        }
        return result;
    }

    fun eatableInRow(): List<Position> {
        var result: MutableList<Position> = mutableListOf();
        for (rank in 1..8) {
            if (rank.toRank() != this.position.rank)
                result.add(Position(rank = rank.toRank(), file = this.position.file))
        }
        return result;
    }

    fun eatableDiagonalTopRightToLeftBottom(): List<Position> {
        var result: MutableList<Position> = mutableListOf();
        var curRank = this.position.rank.value;
        var curFile = this.position.file.value;
        while (curRank in 2..7 && curFile in 2..7) {
            curRank++;
            curFile++;
            result.add(Position(curRank.toRank(),curFile.toFile()));
        }
        curRank = this.position.rank.value;
        curFile = this.position.file.value;
        while (curRank in 2..7 && curFile in 2..7) {
            curRank--;
            curFile--;
            result.add(Position(curRank.toRank(),curFile.toFile()));
        }
        return result;
    }
    fun eatableDiagonalTopLeftToBottomRight(): List<Position> {
        var result: MutableList<Position> = mutableListOf();
        var curRank = this.position.rank.value;
        var curFile = this.position.file.value;
        while (curRank in 2..7 && curFile in 2..7) {
            curRank++;
            curFile--;
            result.add(Position(curRank.toRank(),curFile.toFile()));
        }
        curRank = this.position.rank.value;
        curFile = this.position.file.value;
        while (curRank in 2..7 && curFile in 2..7) {
            curRank--;
            curFile++;
            result.add(Position(curRank.toRank(),curFile.toFile()));
        }
        return result;
    }
}

fun Queen.eatablePosition(): MutableList<Position> {
    var result: MutableList<Position> = mutableListOf();
    result.addAll(this.eatableInRow());
    result.addAll(this.eatableInColumn());
    result.addAll(this.eatableDiagonalTopLeftToBottomRight());
    result.addAll(this.eatableDiagonalTopRightToLeftBottom());
    return result;
}
