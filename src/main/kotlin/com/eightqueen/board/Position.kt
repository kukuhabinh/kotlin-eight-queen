package com.eightqueen.board

import com.eightqueen.error.IllegalArgumentError

enum class Rank(val value: Int) {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    override fun toString(): String = this.name
}

fun Rank.plus(value: Int): Rank = (this.value + value).toRank()
fun Rank.minus(value: Int): Rank = (this.value - value).toRank()


fun Char.toRank() = when (this) {
    'A', 'a' -> Rank.A
    'B', 'b' -> Rank.B
    'C', 'c' -> Rank.C
    'D', 'd' -> Rank.D
    'E', 'e' -> Rank.E
    'F', 'f' -> Rank.F
    'G', 'g' -> Rank.G
    'H', 'h' -> Rank.H
    else -> throw IllegalRankError(this)
}

fun Int.toRank() = when (this) {
    1 -> Rank.A
    2 -> Rank.B
    3 -> Rank.C
    4 -> Rank.D
    5 -> Rank.E
    6 -> Rank.F
    7 -> Rank.G
    8 -> Rank.H
    else -> throw IllegalRankError("Illegal Rank Value $this")
}

class IllegalRankError : IllegalArgumentError {
    constructor() : super()
    constructor(value: Char) : super("$value is not a valid Rank")
    constructor(message: String) : super(message)
    constructor(error: Throwable) : super(error)
}


enum class File(val value: Int) {
    F1(1),
    F2(2),
    F3(3),
    F4(4),
    F5(5),
    F6(6),
    F7(7),
    F8(8);

    override fun toString(): String = "${this.value}"
}

fun File.plus(value: Int): File = (this.value + value).toFile()
fun File.minus(value: Int): File = (this.value - value).toFile()

fun Int.toFile() = when (this) {
    1 -> File.F1
    2 -> File.F2
    3 -> File.F3
    4 -> File.F4
    5 -> File.F5
    6 -> File.F6
    7 -> File.F7
    8 -> File.F8
    else -> throw IllegalFileError(this)
}

class IllegalFileError : IllegalArgumentError {
    constructor() : super()
    constructor(value: Int) : super("$value is not a valid File")
    constructor(message: String) : super(message)
    constructor(error: Throwable) : super(error)
}


data class Position(val rank: Rank, val file: File) {
    override fun toString(): String = "$rank$file"
}

fun String.toPosition(): Position {
    try {
        return Position(rank = this[0].toRank(), file = this[1].toString().toInt().toFile())
    } catch (e: Exception) {
        throw IllegalPositionError(e)
    }
}

class IllegalPositionError : IllegalArgumentError {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(error: Throwable) : super(error)
}


