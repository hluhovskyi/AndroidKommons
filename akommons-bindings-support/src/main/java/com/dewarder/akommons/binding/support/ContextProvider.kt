package com.dewarder.akommons.binding.support

import android.content.Context
import android.support.v4.app.Fragment

internal val Fragment.contextProvider: () -> Context
    inline get() = this::getContext