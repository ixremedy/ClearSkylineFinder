package com.forthreal.tests

import com.forthreal.application.classes.Building
import com.forthreal.application.classes.SkylineView
import org.junit.Before
import org.junit.Test
import javax.xml.ws.Holder
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ClearViewTest
{

    val hViews = Holder<MutableList<Pair<Int,Int>>>()

    @Before
    fun beforeClass()
    {
        val skylineView =
                SkylineView(
                    Building(1, 15, 3),
                    Building(4,11,5),
                    Building(19,23,4)
                )

        hViews.value = skylineView.getClearViewChange()
    }


    @Test
    fun test1()
    {
        assertNotEquals( null, hViews.value.get(0) )
        assertEquals( 1, hViews.value.get(0).first )
        assertEquals( 3, hViews.value.get(0).second )
    }

    @Test
    fun test2()
    {
        assertNotEquals( null, hViews.value.get(1) )
        assertEquals( 4, hViews.value.get(1).first )
        assertEquals( 5, hViews.value.get(1).second )
    }

    @Test
    fun test3()
    {
        assertNotEquals( null, hViews.value.get(2) )
        assertEquals( 12, hViews.value.get(2).first )
        assertEquals( 3, hViews.value.get(2).second )
    }

    @Test
    fun test4()
    {
        assertNotEquals( null, hViews.value.get(3) )
        assertEquals( 16, hViews.value.get(3).first )
        assertEquals( 0, hViews.value.get(3).second )
    }

    @Test
    fun test5()
    {
        assertNotEquals( null, hViews.value.get(4) )
        assertEquals( 19, hViews.value.get(4).first )
        assertEquals( 4, hViews.value.get(4).second )
    }
}