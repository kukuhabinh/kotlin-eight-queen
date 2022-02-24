package com.eightqueen.solution

import com.eightqueen.board.Board
import com.eightqueen.pieces.Queen

class Solution(val firstQueen: Queen) {
    val board: Board = Board();
    fun ini() {
        board.put(queen = firstQueen);
    }
}