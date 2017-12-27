package com.dewarder.katanatest.integer

import android.content.res.Resources
import com.dewarder.katanatest.get
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.reflect.KProperty

abstract class BaseIntegerTest {

    @get:Rule
    val exceptionRule = ExpectedException.none()

    private lateinit var integerRequiredExist: KProperty<Int>
    private lateinit var integerRequiredAbsent: KProperty<Int>
    private lateinit var integerOptionalExist: KProperty<Int?>
    private lateinit var integerOptionalAbsent: KProperty<Int?>

    private lateinit var integersRequiredExist: KProperty<List<Int>>
    private lateinit var integersRequiredAbsent: KProperty<List<Int>>
    private lateinit var integersOptionalExist: KProperty<List<Int?>>
    private lateinit var integersOptionalAbsent: KProperty<List<Int?>>
    private lateinit var integersRequiredFirstExistSecondAbsent: KProperty<List<Int>>
    private lateinit var integersOptionalFirstExistSecondAbsent: KProperty<List<Int?>>

    abstract fun getTestableInteger(): TestableInteger

    @Before
    fun init() {
        getTestableInteger().let {
            integerRequiredExist = it::integerRequiredExist
            integerRequiredAbsent = it::integerRequiredAbsent
            integerOptionalExist = it::integerOptionalExist
            integerOptionalAbsent = it::integerOptionalAbsent

            integersRequiredExist = it::integersRequiredExist
            integersRequiredAbsent = it::integersRequiredAbsent
            integersOptionalExist = it::integersOptionalExist
            integersOptionalAbsent = it::integersOptionalAbsent
            integersRequiredFirstExistSecondAbsent = it::integersRequiredFirstExistSecondAbsent
            integersOptionalFirstExistSecondAbsent = it::integersOptionalFirstExistSecondAbsent
        }
    }

    @Test
    fun testOneIntegerRequiredExist() {
        assertEquals(integerRequiredExist.get(), 1)
    }

    @Test
    fun testOneIntegerRequiredAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        integerRequiredAbsent.get()
    }

    @Test
    fun testOneIntegerOptionalExist() {
        assertEquals(integerOptionalExist.get(), 1)
    }

    @Test
    fun testOneIntegerOptionalAbsent() {
        assertNull(integerOptionalAbsent.get())
    }

    @Test
    fun testManyIntegersRequiredExist() {
        val list = integersRequiredExist.get()
        assertEquals(list.size, 2)
        assertEquals(list.first(), 1)
        assertEquals(list.last(), 2)
    }

    @Test
    fun testManyIntegersRequiredAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        integersRequiredAbsent.get()
    }

    @Test
    fun testManyIntegersOptionalExist() {
        val list = integersOptionalExist.get()
        assertEquals(list.size, 2)
        assertEquals(list.first(), 1)
        assertEquals(list.last(), 2)
    }

    @Test
    fun testManyIntegersOptionalAbsent() {
        val list = integersOptionalAbsent.get()
        assertEquals(list.size, 2)
        assertNull(list.first())
        assertNull(list.last())
    }

    @Test
    fun testManyIntegersRequiredFirstExistSecondAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        integersRequiredFirstExistSecondAbsent.get()
    }

    @Test
    fun testManyIntegersOptionalFirstExistSecondAbsent() {
        val list = integersOptionalFirstExistSecondAbsent.get()
        assertEquals(list.size, 2)
        assertEquals(list.first(), 1)
        assertNull(list.last())
    }
}