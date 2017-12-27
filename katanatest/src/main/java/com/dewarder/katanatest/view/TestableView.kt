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

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

interface TestableView {

    val viewRequiredExist: View
    val viewRequiredAbsent: View
    val viewOptionalExist: View?
    val viewOptionalAbsent: View?

    val textViewRequiredCorrect: TextView
    val textViewRequiredIncorrect: LinearLayout
    val textViewOptionalCorrect: TextView?
    val textViewOptionalIncorrect: LinearLayout?

    val viewsRequiredExist: List<View>
    val viewsRequiredAbsent: List<View>
    val viewsOptionalExist: List<View?>
    val viewsOptionalAbsent: List<View?>
    val viewsRequiredFirstExistSecondAbsent: List<View>
    val viewsOptionalFirstExistSecondAbsent: List<View?>

    val viewsRequiredExistCorrect: List<TextView>
    val viewsRequiredExistIncorrect: List<TextView>
    val viewsRequiredExistFirstViewSecondTextViewCorrect: List<View>
    val viewsOptionalExistCorrect: List<TextView?>
    val viewsOptionalExistIncorrect: List<TextView?>
    val viewsOptionalExistFirstViewSecondTextViewCorrect: List<View?>
}