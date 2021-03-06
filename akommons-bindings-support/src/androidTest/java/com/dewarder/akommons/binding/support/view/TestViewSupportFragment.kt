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

package com.dewarder.akommons.binding.support.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.akommons.binding.common.NO_VIEW1
import com.dewarder.akommons.binding.common.NO_VIEW2
import com.dewarder.akommons.binding.common.R
import com.dewarder.akommons.binding.common.view.TestableView
import com.dewarder.akommons.binding.support.view
import com.dewarder.akommons.binding.support.viewOptional
import com.dewarder.akommons.binding.support.views
import com.dewarder.akommons.binding.support.viewsOptional

class TestViewSupportFragment : Fragment(), TestableView {

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.activity_test_view, container, false)
    }

}