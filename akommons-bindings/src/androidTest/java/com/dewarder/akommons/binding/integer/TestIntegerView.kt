package com.dewarder.akommons.binding.integer

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.dewarder.akommons.binding.integer
import com.dewarder.akommons.binding.integerOptional
import com.dewarder.akommons.binding.integers
import com.dewarder.akommons.binding.integersOptional
import com.dewarder.akommons.binding.NO_INTEGER1
import com.dewarder.akommons.binding.NO_INTEGER2
import com.dewarder.akommons.test.R

class TestIntegerView : View, TestableInteger {

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

    constructor(context: Context) : super(context)
}