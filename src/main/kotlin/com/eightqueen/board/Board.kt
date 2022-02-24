package com.eightqueen.board

import com.eightqueen.pieces.Queen
import com.eightqueen.pieces.eatablePosition

class Board {
    constructor() {
        for (rank in 1..8) {
            for (file in 1..8) {
                this.safePosition.add(Position(rank.toRank(),file.toFile()))
            }
        }
    }
    private val safePosition:MutableList<Position> = mutableListOf();

    fun put(queen: Queen) {
        removePositionFromSafePosition(queen.position);
        removeAllEatablePositionFromSafePosition(queen)
    }

    private fun removeAllEatablePositionFromSafePosition(queen: Queen) = queen.eatablePosition().forEach { removePositionFromSafePosition(it) }

    private fun removePositionFromSafePosition(position: Position) {
        this.safePosition.remove(position)
    }
    private fun allPositionInRank(rank:Rank): List<Position> {
        return listOf(
            Position(rank,1.toFile()),
            Position(rank,2.toFile()),
            Position(rank,3.toFile()),
            Position(rank,4.toFile()),
            Position(rank,5.toFile()),
            Position(rank,6.toFile()),
            Position(rank,7.toFile()),
            Position(rank,8.toFile()),
        );
    }

    fun randomPositionFromSafePositionAndRank(rank:Rank) : Position {
        var listPosition:List<Position> = allPositionInRank(rank);
        return listPosition.filter { this.safePosition.contains(it) }.random();
    }
}