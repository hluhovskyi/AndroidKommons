package com.dewarder.katanatest.string

import android.content.Context
import android.view.View
import com.dewarder.katana.string
import com.dewarder.katana.stringOptional
import com.dewarder.katana.strings
import com.dewarder.katana.stringsOptional
import com.dewarder.katanatest.NO_STRING1
import com.dewarder.katanatest.NO_STRING2
import com.dewarder.katanatest.R

class TestStringView : View, TestableString {

    override val stringRequiredExist by string(R.string.test_string1)
    override val stringRequiredAbsent by string(NO_STRING1)
    override val stringOptionalExist by stringOptional(R.string.test_string1)
    override val stringOptionalAbsent by stringOptional(NO_STRING1)

    override val stringsRequiredExist by strings(R.string.test_string1, R.string.test_string2)
    override val stringsRequiredAbsent by strings(NO_STRING1, NO_STRING2)
    override val stringsOptionalExist by stringsOptional(R.string.test_string1, R.string.test_string2)
    override val stringsOptionalAbsent by stringsOptional(NO_STRING1, NO_STRING2)
    override val stringsRequiredFirstExistSecondAbsent by strings(R.string.test_string1, NO_STRING1)
    override val stringsOptionalFirstExistSecondAbsent by stringsOptional(R.string.test_string1, NO_STRING1)

    constructor(context: Context) : super(context)
}