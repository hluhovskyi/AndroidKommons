/*
 * Copyright (C) 2017 Artem Hluhovskyi
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

package com.dewarder.akommons.binding.dimen

import android.support.v7.app.AppCompatActivity
import com.dewarder.akommons.binding.*
import com.dewarder.akommons.test.R

class TestDimenActivity : AppCompatActivity(), TestableDimen {

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