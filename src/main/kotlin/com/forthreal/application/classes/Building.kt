package com.forthreal.application.classes

class Building
{
    val dimensions: Triple<Int, Int, Int>

    constructor(left: Int, right: Int, height: Int)
    {
        if( intArrayOf(left, right, height).filter { it > 0 }.size < 3 )
        {
            throw Exception("No dimension can be equal or below zero")
        }

        if( left >= right )
        {
            throw Exception("A building cannot have subtractive or zero width")
        }

        dimensions = Triple(left, right, height)
    }

}