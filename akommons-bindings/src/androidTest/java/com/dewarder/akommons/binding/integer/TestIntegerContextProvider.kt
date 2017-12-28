package com.dewarder.akommons.binding.integer

import android.content.Context
import com.dewarder.akommons.binding.*
import com.dewarder.akommons.binding.common.NO_INTEGER1
import com.dewarder.akommons.binding.common.NO_INTEGER2
import com.dewarder.akommons.binding.common.integer.TestableInteger
import com.dewarder.akommons.binding.common.R

class TestIntegerContextProvider(private val context: Context) : ContextProvider, TestableInteger {

    override fun provideContext() = context

    override val integerRequiredExist by integer(R.integer.test_integer_1)
    override val integerRequiredAbsent by integer(NO_INTEGER1)
    override val integerOptionalExist by integerOptional(R.integer.test_integer_1)
    override val integerOptionalAbsent by integerOptional(NO_INTEGER1)

    override val integersRequiredExist by integers(R.integer.test_integer_1, R.integer.test_integer_2)
    override val integersRequiredAbsent by integers(NO_INTEGER1, NO_INTEGER2)
    override val integersOptionalExist by integersOptional(R.integer.test_integer_1, R.integer.test_integer_2)
    override val integersOptionalAbsent by integersOptional(NO_INTEGER1, NO_INTEGER2)
    override val integersRequiredFirstExistSecondAbsent by integers(R.integer.test_integer_1, NO_INTEGER1)
    override val integersOptionalFirstExistSecondAbsent by integersOptional(R.integer.test_integer_1, NO_INTEGER1)

}