/*
 * Copyright (C) 2017 Artem Glugovsky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dewarder.katanatest.view

import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.katanatest.NO_VIEW1
import com.dewarder.katanatest.NO_VIEW2
import com.dewarder.katanatest.get
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import kotlin.reflect.KProperty

@RunWith(AndroidJUnit4::class)
abstract class BaseViewTest {

    @get:Rule
    val exceptionRule = ExpectedException.none();

    private lateinit var component: Any

    private lateinit var viewRequiredExist: KProperty<View>
    private lateinit var viewRequiredAbsent: KProperty<View>
    private lateinit var viewOptionalExist: KProperty<View?>
    private lateinit var viewOptionalAbsent: KProperty<View?>

    private lateinit var textViewRequiredCorrect: KProperty<TextView>
    private lateinit var textViewRequiredIncorrect: KProperty<LinearLayout>
    private lateinit var textViewOptionalCorrect: KProperty<TextView?>
    private lateinit var textViewOptionalIncorrect: KProperty<LinearLayout?>

    private lateinit var viewsRequiredExist: KProperty<List<View>>
    private lateinit var viewsRequiredAbsent: KProperty<List<View>>
    private lateinit var viewsOptionalExist: KProperty<List<View?>>
    private lateinit var viewsOptionalAbsent: KProperty<List<View?>>
    private lateinit var viewsRequiredFirstExistSecondAbsent: KProperty<List<View>>
    private lateinit var viewsOptionalFirstExistSecondAbsent: KProperty<List<View?>>

    private lateinit var viewsRequiredExistCorrect: KProperty<List<TextView>>
    private lateinit var viewsRequiredExistIncorrect: KProperty<List<TextView>>
    private lateinit var viewsRequiredExistFirstViewSecondTextViewCorrect: KProperty<List<View>>
    private lateinit var viewsOptionalExistCorrect: KProperty<List<TextView?>>
    private lateinit var viewsOptionalExistIncorrect: KProperty<List<TextView?>>
    private lateinit var viewsOptionalExistFirstViewSecondTextViewCorrect: KProperty<List<View?>>

    abstract fun getTestableView(): TestableView

    @Before
    fun init() {
        getTestableView().let {
            component = it

            viewRequiredExist = it::viewRequiredExist
            viewRequiredAbsent = it::viewRequiredAbsent
            viewOptionalExist = it::viewOptionalExist
            viewOptionalAbsent = it::viewOptionalAbsent

            textViewRequiredCorrect = it::textViewRequiredCorrect
            textViewRequiredIncorrect = it::textViewRequiredIncorrect
            textViewOptionalCorrect = it::textViewOptionalCorrect
            textViewOptionalIncorrect = it::textViewOptionalIncorrect

            viewsRequiredExist = it::viewsRequiredExist
            viewsRequiredAbsent = it::viewsRequiredAbsent
            viewsOptionalExist = it::viewsOptionalExist
            viewsOptionalAbsent = it::viewsOptionalAbsent
            viewsRequiredFirstExistSecondAbsent = it::viewsRequiredFirstExistSecondAbsent
            viewsOptionalFirstExistSecondAbsent = it::viewsOptionalFirstExistSecondAbsent

            viewsRequiredExistCorrect = it::viewsRequiredExistCorrect
            viewsRequiredExistIncorrect = it::viewsRequiredExistIncorrect
            viewsRequiredExistFirstViewSecondTextViewCorrect = it::viewsRequiredExistFirstViewSecondTextViewCorrect
            viewsOptionalExistCorrect = it::viewsOptionalExistCorrect
            viewsOptionalExistIncorrect = it::viewsOptionalExistIncorrect
            viewsOptionalExistFirstViewSecondTextViewCorrect = it::viewsOptionalExistFirstViewSecondTextViewCorrect
        }
    }

    @Test
    fun testOneRequiredViewExist() {
        viewRequiredExist.call()
    }

    @Test
    fun testOneRequiredViewAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        viewRequiredAbsent.get()
    }

    @Test
    fun testOneOptionalViewExist() {
        assertNotNull(viewOptionalExist.get())
    }

    @Test
    fun testOneOptionalViewNotExist() {
        assertNull(viewOptionalAbsent.get())
    }

    @Test
    fun testOneRequiredViewExistAndCorrectClass() {
        assertTrue(textViewRequiredCorrect.get() is TextView)
    }

    @Test
    fun testOneRequiredViewExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        assertFalse(textViewRequiredIncorrect.get() is LinearLayout)
    }

    @Test
    fun testOneOptionalViewExistAndCorrectClass() {
        assertNotNull(textViewOptionalCorrect.get())
        assertTrue(textViewOptionalCorrect.get() is TextView)
    }

    @Test
    fun testOneOptionalViewExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        assertFalse(textViewOptionalIncorrect.get() is LinearLayout)
    }

    @Test
    fun testManyRequiredViewAllExist() {
        val size = viewsRequiredExist.get().filterNotNull().size
        assertEquals(size, 2)
    }

    @Test
    fun testManyRequiredViewAllAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        exceptionRule.expectMessage(component::class.java.simpleName)
        exceptionRule.expectMessage(NO_VIEW1.toString())
        exceptionRule.expectMessage(NO_VIEW2.toString())
        exceptionRule.expectMessage(viewsRequiredAbsent.name)
        viewsRequiredAbsent.get()
    }

    @Test
    fun testManyOptionalViewAllExist() {
        val size = viewsOptionalExist.get().filterNotNull().size
        assertEquals(size, 2)
    }

    @Test
    fun testManyOptionalViewAllAbsent() {
        val size = viewsOptionalAbsent.get().size
        assertEquals(size, 2)
        val nonNullSize = viewsOptionalAbsent.get().filterNotNull().size
        assertEquals(nonNullSize, 0)
    }

    @Test
    fun testManyRequiredFirstExistSecondAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        exceptionRule.expectMessage(component::class.java.simpleName)
        exceptionRule.expectMessage(NO_VIEW1.toString())
        exceptionRule.expectMessage(viewsRequiredFirstExistSecondAbsent.name)
        viewsRequiredFirstExistSecondAbsent.get()
    }

    @Test
    fun testManyOptionalFirstExistSecondAbsent() {
        val viewList = viewsOptionalFirstExistSecondAbsent.get()
        assertEquals(viewList.size, 2)
        assertNotNull(viewList.first())
        assertNull(viewList.last())
    }

    @Test
    fun testManyRequiredAllExistAndCorrectClass() {
        val viewList = viewsRequiredExistCorrect.get()
        assertEquals(viewList.size, 2)
        assertEquals(viewList.filterIsInstance<TextView>().size, 2)
    }

    @Test
    fun testManyRequiredAllExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        viewsRequiredExistIncorrect.get()
    }

    @Test
    fun testManyRequiredAllDifferentClassCorrect() {
        val viewList = viewsRequiredExistFirstViewSecondTextViewCorrect.get()
        assertEquals(viewList.size, 2)
        assertTrue(viewList.first() is View)
        assertTrue(viewList.last() is TextView)
    }

    @Test
    fun testManyOptionalAllExistAndCorrectClass() {
        val viewList = viewsOptionalExistCorrect.get()
        assertEquals(viewList.size, 2)
        assertEquals(viewList.filterIsInstance<TextView>().size, 2)
    }

    @Test
    fun testManyOptionalAllExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        viewsOptionalExistIncorrect.get()
    }

    @Test
    fun testManyOptionalAllDifferentClassCorrect() {
        val viewList = viewsOptionalExistFirstViewSecondTextViewCorrect.get()
        assertEquals(viewList.size, 2)
        assertTrue(viewList.first() is View)
        assertTrue(viewList.last() is TextView)
    }
}
