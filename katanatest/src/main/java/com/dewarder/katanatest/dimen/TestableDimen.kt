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

package com.dewarder.katanatest.dimen

interface TestableDimen {

    val dimenRequiredExist: Float
    val dimenRequiredAbsent: Float
    val dimenOptionalExist: Float?
    val dimenOptionalAbsent: Float?

    val dimenRequiredExistPx: Float
    val dimenRequiredExistDp: Float
    val dimenRequiredExistSp: Float
    val dimenOptionalExistPx: Float?
    val dimenOptionalExistDp: Float?
    val dimenOptionalExistSp: Float?

    val dimensRequiredAllExist: List<Float>
    val dimensRequiredAllAbsent: List<Float>
    val dimensOptionalAllExist: List<Float?>
    val dimensOptionalAllAbsent: List<Float?>
    val dimensRequiredFirstExistSecondAbsent: List<Float>
    val dimensOptionalFirstExistSecondAbsent: List<Float?>

    val dimensRequiredExistPxDpSpAllPx: List<Float>
    val dimensOptionalExistPxDpSpAllPx: List<Float?>
    val dimensRequiredExistPxDpSpAllDp: List<Float>
    val dimensOptionalExistPxDpSpAllDp: List<Float?>

}