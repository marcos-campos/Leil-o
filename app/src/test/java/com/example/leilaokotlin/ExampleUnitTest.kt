package com.example.leilaokotlin

import com.example.leilaokotlin.model.Usuario
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        assertNotEquals(3, 2 +2)

        assertTrue(true)
        assertFalse(false)

        assertNull(null)
        assertNotNull(Usuario("Alex"))

        assertThat(2 + 2, equalTo(4))
    }
}