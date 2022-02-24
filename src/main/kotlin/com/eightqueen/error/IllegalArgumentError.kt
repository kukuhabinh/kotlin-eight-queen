package com.eightqueen.error

open class IllegalArgumentError : Exception{
    constructor():super();
    constructor(message: String) : super(message)
    constructor(error: Throwable) : super(error)
}