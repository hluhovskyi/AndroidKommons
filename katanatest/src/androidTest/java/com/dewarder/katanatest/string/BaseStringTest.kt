package com.dewarder.katanatest.string

import android.content.res.Resources
import com.dewarder.katanatest.get
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.reflect.KProperty

abstract class BaseStringTest {

    @get:Rule
    val exceptionRule = ExpectedException.none()

    private lateinit var stringRequiredExist: KProperty<String>
    private lateinit var stringRequiredAbsent: KProperty<String>
    private lateinit var stringOptionalExist: KProperty<String?>
    private lateinit var stringOptionalAbsent: KProperty<String?>

    private lateinit var stringsRequiredExist: KProperty<List<String>>
    private lateinit var stringsRequiredAbsent: KProperty<List<String>>
    private lateinit var stringsOptionalExist: KProperty<List<String?>>
    private lateinit var stringsOptionalAbsent: KProperty<List<String?>>
    private lateinit var stringsRequiredFirstExistSecondAbsent: KProperty<List<String>>
    private lateinit var stringsOptionalFirstExistSecondAbsent: KProperty<List<String?>>

    abstract fun getTestableString(): TestableString

    @Before
    fun init() {
        getTestableString().let {
            stringRequiredExist = it::stringRequiredExist
            stringRequiredAbsent = it::stringRequiredAbsent
            stringOptionalExist = it::stringOptionalExist
            stringOptionalAbsent = it::stringOptionalAbsent

            stringsRequiredExist = it::stringsRequiredExist
            stringsRequiredAbsent = it::stringsRequiredAbsent
            stringsOptionalExist = it::stringsOptionalExist
            stringsOptionalAbsent = it::stringsOptionalAbsent
            stringsRequiredFirstExistSecondAbsent = it::stringsRequiredFirstExistSecondAbsent
            stringsOptionalFirstExistSecondAbsent = it::stringsOptionalFirstExistSecondAbsent
        }
    }

    @Test
    fun testOneStringRequiredExist() {
        assertEquals(stringRequiredExist.get(), "test1")
    }

    @Test
    fun testOneStringRequiredAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        stringRequiredAbsent.get()
    }

    @Test
    fun testOneStringOptionalExist() {
        assertEquals(stringOptionalExist.get(), "test1")
    }

    @Test
    fun testOneStringOptionalAbsent() {
        assertNull(stringOptionalAbsent.get())
    }

    @Test
    fun testManyStringsRequiredExist() {
        val list = stringsRequiredExist.get()
        assertEquals(list.size, 2)
        assertEquals(list.first(), "test1")
        assertEquals(list.last(), "test2")
    }

    @Test
    fun testManyStringsRequiredAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        stringsRequiredAbsent.get()
    }

    @Test
    fun testManyStringsOptionalExist() {
        val list = stringsOptionalExist.get()
        assertEquals(list.size, 2)
        assertEquals(list.first(), "test1")
        assertEquals(list.last(), "test2")
    }

    @Test
    fun testManyStringsOptionalAbsent() {
        val list = stringsOptionalAbsent.get()
        assertEquals(list.size, 2)
        assertNull(list.first())
        assertNull(list.last())
    }

    @Test
    fun testManyStringsRequiredFirstExistSecondAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        stringsRequiredFirstExistSecondAbsent.get()
    }

    @Test
    fun testManyStringsOptionalFirstExistSecondAbsent() {
        val list = stringsOptionalFirstExistSecondAbsent.get()
        assertEquals(list.size, 2)
        assertEquals(list.first(), "test1")
        assertNull(list.last())
    }
}