package com.dewarder.katanatest.integer

import android.app.Dialog
import android.content.Context
import com.dewarder.katana.integer
import com.dewarder.katana.integerOptional
import com.dewarder.katana.integers
import com.dewarder.katana.integersOptional
import com.dewarder.katanatest.NO_INTEGER1
import com.dewarder.katanatest.NO_INTEGER2
import com.dewarder.katanatest.R

class TestIntegerDialog : Dialog, TestableInteger {

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