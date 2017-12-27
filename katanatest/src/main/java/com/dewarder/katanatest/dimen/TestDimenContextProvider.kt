package com.dewarder.katanatest.dimen

import android.content.Context
import android.view.View
import com.dewarder.katana.*
import com.dewarder.katanatest.NO_DIMEN1
import com.dewarder.katanatest.NO_DIMEN2
import com.dewarder.katanatest.R

class TestDimenContextProvider(private val context: Context) : ContextProvider, TestableDimen {

    override fun provideContext() = context

    override val dimenRequiredExist by dimen(R.dimen.test_dimen_8dp)
    override val dimenRequiredAbsent by dimen(NO_DIMEN1)
    override val dimenOptionalExist by dimenOptional(R.dimen.test_dimen_8dp)
    override val dimenOptionalAbsent by dimenOptional(NO_DIMEN1)

    override val dimenRequiredExistPx by dimen(R.dimen.test_dimen_8px, DimensionType.PX)
    override val dimenRequiredExistDp by dimen(R.dimen.test_dimen_8dp, DimensionType.DP)
    override val dimenRequiredExistSp by dimen(R.dimen.test_dimen_8sp, DimensionType.SP)
    override val dimenOptionalExistPx by dimen(R.dimen.test_dimen_8px, DimensionType.PX)
    override val dimenOptionalExistDp by dimen(R.dimen.test_dimen_8dp, DimensionType.DP)
    override val dimenOptionalExistSp by dimen(R.dimen.test_dimen_8sp, DimensionType.SP)

    override val dimensRequiredAllExist by dimens(R.dimen.test_dimen_4dp, R.dimen.test_dimen_8dp)
    override val dimensRequiredAllAbsent by dimens(NO_DIMEN1, NO_DIMEN2)
    override val dimensOptionalAllExist by dimensOptional(R.dimen.test_dimen_4dp, R.dimen.test_dimen_8dp)
    override val dimensOptionalAllAbsent by dimensOptional(NO_DIMEN1, NO_DIMEN2)
    override val dimensRequiredFirstExistSecondAbsent by dimens(R.dimen.test_dimen_4dp, NO_DIMEN1)
    override val dimensOptionalFirstExistSecondAbsent by dimensOptional(R.dimen.test_dimen_4dp, NO_DIMEN1)

    override val dimensRequiredExistPxDpSpAllPx by dimens(R.dimen.test_dimen_8px, R.dimen.test_dimen_8dp, R.dimen.test_dimen_8sp)
    override val dimensOptionalExistPxDpSpAllPx by dimensOptional(R.dimen.test_dimen_8px, R.dimen.test_dimen_8dp, R.dimen.test_dimen_8sp)
    override val dimensRequiredExistPxDpSpAllDp by dimens(R.dimen.test_dimen_8px, R.dimen.test_dimen_8dp, R.dimen.test_dimen_8sp, dimension = DimensionType.DP)
    override val dimensOptionalExistPxDpSpAllDp by dimens(R.dimen.test_dimen_8px, R.dimen.test_dimen_8dp, R.dimen.test_dimen_8sp, dimension = DimensionType.DP)
}