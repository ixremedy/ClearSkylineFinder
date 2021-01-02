package com.forthreal.application.classes

class SkylineView
{
    val highest: Int
    val mostRightPoint: Int
    val buildings = mutableListOf<Building>()

    constructor(vararg buildings: Building)
    {
        var currentHeight: Int = 0
        var currentMostRightPoint: Int = 0

        buildings.iterator().forEach {

            val height = it.dimensions.third
            val lastPoint = it.dimensions.second

            if( height > currentHeight )
            {
                currentHeight = height
            }

            if( currentMostRightPoint < lastPoint )
            {
                currentMostRightPoint = lastPoint
            }

            this.buildings.add( it )

        }

        highest = currentHeight
        mostRightPoint = currentMostRightPoint
    }


    public fun getClearViewChange() : MutableList< Pair<Int, Int> >
    {
        var lastHeight : Int = 0

        val clearViewSpans = mutableListOf< Pair<Int, Int> >()

        for( x in 1..mostRightPoint )
        {
            val currentHeight =
                    buildings
                        .filter { ( it.dimensions.first <= x ) && ( it.dimensions.second >= x )  }
                        .maxByOrNull { it.dimensions.third }
                        ?.dimensions
                        ?.third

            //System.out.println("x ${x} cH ${currentHeight}")

            currentHeight?.let {

                /* change in height */
                if( ( currentHeight != lastHeight ) || ( lastHeight == 0 ) )
                {
                    clearViewSpans.add( Pair(x, currentHeight) )
                    lastHeight = currentHeight
                }
            } ?: run {

                if( lastHeight != 0 )
                {
                    clearViewSpans.add( Pair(x, 0) )
                    lastHeight = 0
                }

            }

        }

        return clearViewSpans
    }
}