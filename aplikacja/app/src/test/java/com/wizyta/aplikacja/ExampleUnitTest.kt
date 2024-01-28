package com.wizyta.aplikacja

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun good1() {
        assertEquals(4*2*2, 7*2+2)
    }
    @Test
    fun good2() {
        assertNotEquals(1, 2)
    }
}