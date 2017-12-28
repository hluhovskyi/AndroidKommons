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

package com.dewarder.akommons.binding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.support.annotation.AnimRes
import android.support.annotation.RestrictTo
import android.view.View
import android.view.animation.Animation
import com.dewarder.akommons.binding.util.contextProvider
import com.dewarder.akommons.binding.util.getAnimation
import com.dewarder.akommons.binding.util.getSafeAnimation
import com.dewarder.akommons.util.Optional
import com.dewarder.akommons.util.Required
import kotlin.properties.ReadOnlyProperty


/**
 * View
 */
fun View.animation(@AnimRes animationRes: Int): ReadOnlyProperty<View, Animation>
        = requiredAnimation(contextProvider, animationRes)

fun View.animationOptional(@AnimRes animationRes: Int): ReadOnlyProperty<View, Animation?>
        = optionalAnimation(contextProvider, animationRes)

fun View.animations(@AnimRes vararg animationRes: Int): ReadOnlyProperty<View, List<Animation>>
        = requiredAnimations(contextProvider, animationRes)

fun View.animationsOptional(@AnimRes vararg animationRes: Int): ReadOnlyProperty<View, List<Animation?>>
        = optionalAnimations(contextProvider, animationRes)

/**
 * Activity
 */
fun Activity.animation(@AnimRes animationRes: Int): ReadOnlyProperty<Activity, Animation>
        = requiredAnimation(contextProvider, animationRes)

fun Activity.animationOptional(@AnimRes animationRes: Int): ReadOnlyProperty<Activity, Animation?>
        = optionalAnimation(contextProvider, animationRes)

fun Activity.animations(@AnimRes vararg animationRes: Int): ReadOnlyProperty<Activity, List<Animation>>
        = requiredAnimations(contextProvider, animationRes)

fun Activity.animationsOptional(@AnimRes vararg animationRes: Int): ReadOnlyProperty<Activity, List<Animation?>>
        = optionalAnimations(contextProvider, animationRes)

/**
 * Fragment
 */
fun Fragment.animation(@AnimRes animationRes: Int): ReadOnlyProperty<Fragment, Animation>
        = requiredAnimation(contextProvider, animationRes)

fun Fragment.animationOptional(@AnimRes animationRes: Int): ReadOnlyProperty<Fragment, Animation?>
        = optionalAnimation(contextProvider, animationRes)

fun Fragment.animations(@AnimRes vararg animationRes: Int): ReadOnlyProperty<Fragment, List<Animation>>
        = requiredAnimations(contextProvider, animationRes)

fun Fragment.animationsOptional(@AnimRes vararg animationRes: Int): ReadOnlyProperty<Fragment, List<Animation?>>
        = optionalAnimations(contextProvider, animationRes)

/**
 * Dialog
 */
fun Dialog.animation(@AnimRes animationRes: Int): ReadOnlyProperty<Dialog, Animation>
        = requiredAnimation(contextProvider, animationRes)

fun Dialog.animationOptional(@AnimRes animationRes: Int): ReadOnlyProperty<Dialog, Animation?>
        = optionalAnimation(contextProvider, animationRes)

fun Dialog.animations(@AnimRes vararg animationRes: Int): ReadOnlyProperty<Dialog, List<Animation>>
        = requiredAnimations(contextProvider, animationRes)

fun Dialog.animationsOptional(@AnimRes vararg animationRes: Int): ReadOnlyProperty<Dialog, List<Animation?>>
        = optionalAnimations(contextProvider, animationRes)

/**
 * ContextProvider
 */
fun ContextProvider.animation(@AnimRes animationRes: Int): ReadOnlyProperty<ContextProvider, Animation>
        = requiredAnimation(this::provideContext, animationRes)

fun ContextProvider.animationOptional(@AnimRes animationRes: Int): ReadOnlyProperty<ContextProvider, Animation?>
        = optionalAnimation(this::provideContext, animationRes)

fun ContextProvider.animations(@AnimRes vararg animationRes: Int): ReadOnlyProperty<ContextProvider, List<Animation>>
        = requiredAnimations(this::provideContext, animationRes)

fun ContextProvider.animationsOptional(@AnimRes vararg animationRes: Int): ReadOnlyProperty<ContextProvider, List<Animation?>>
        = optionalAnimations(this::provideContext, animationRes)


/**
 * Getters
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> requiredAnimation(crossinline contextProvider: () -> Context, @AnimRes animationRes: Int): ReadOnlyProperty<R, Animation> {
    return Required { contextProvider().getAnimation(animationRes) }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> optionalAnimation(crossinline contextProvider: () -> Context, @AnimRes animationRes: Int): ReadOnlyProperty<R, Animation?> {
    return Optional { contextProvider().getSafeAnimation(animationRes) }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> requiredAnimations(crossinline contextProvider: () -> Context, @AnimRes animationRes: IntArray): ReadOnlyProperty<R, List<Animation>> {
    return Required {
        val context = contextProvider()
        animationRes.map(context::getAnimation)
    }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> optionalAnimations(crossinline contextProvider: () -> Context, @AnimRes animationRes: IntArray): ReadOnlyProperty<R, List<Animation?>> {
    return Required {
        val context = contextProvider()
        animationRes.map(context::getSafeAnimation)
    }
}
