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

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.katana.view
import com.dewarder.katana.viewOptional
import com.dewarder.katana.views
import com.dewarder.katana.viewsOptional
import com.dewarder.katanatest.NO_VIEW1
import com.dewarder.katanatest.NO_VIEW2
import com.dewarder.katanatest.R
import com.dewarder.katanatest.view.TestableView

class TestViewDialog : Dialog, TestableView {

    override val viewRequiredExist: View by view(R.id.test_view1)
    override val viewRequiredAbsent: View by view(NO_VIEW1)
    override val viewOptionalExist: View? by viewOptional(R.id.test_view1)
    override val viewOptionalAbsent: View? by viewOptional(NO_VIEW1)

    override val textViewRequiredCorrect: TextView by view(R.id.test_text_view1)
    override val textViewRequiredIncorrect: LinearLayout by view(R.id.test_text_view1)
    override val textViewOptionalCorrect: TextView? by viewOptional(R.id.test_text_view1)
    override val textViewOptionalIncorrect: LinearLayout? by viewOptional(R.id.test_text_view1)

    override val viewsRequiredExist: List<View> by views(R.id.test_view1, R.id.test_view2)
    override val viewsRequiredAbsent: List<View> by views(NO_VIEW1, NO_VIEW2)
    override val viewsOptionalExist: List<View?> by viewsOptional(R.id.test_view1, R.id.test_view2)
    override val viewsOptionalAbsent: List<View?> by viewsOptional(NO_VIEW1, NO_VIEW2)
    override val viewsRequiredFirstExistSecondAbsent: List<View> by views(R.id.test_view1, NO_VIEW1)
    override val viewsOptionalFirstExistSecondAbsent: List<View?> by viewsOptional(R.id.test_view1, NO_VIEW1)

    override val viewsRequiredExistCorrect: List<TextView> by views(R.id.test_text_view1, R.id.test_text_view2)
    override val viewsRequiredExistIncorrect: List<TextView> by views(R.id.test_text_view1, R.id.test_view1)
    override val viewsRequiredExistFirstViewSecondTextViewCorrect: List<View> by views(R.id.test_view1, R.id.test_text_view1)
    override val viewsOptionalExistCorrect: List<TextView?> by viewsOptional(R.id.test_text_view1, R.id.test_text_view2)
    override val viewsOptionalExistIncorrect: List<TextView?> by viewsOptional(R.id.test_text_view1, R.id.test_view1)
    override val viewsOptionalExistFirstViewSecondTextViewCorrect: List<View?> by viewsOptional(R.id.test_view1, R.id.test_text_view1)

    constructor(context: Context) : super(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view)
    }
}