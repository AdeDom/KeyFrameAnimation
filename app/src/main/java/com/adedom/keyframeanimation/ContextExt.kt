package com.adedom.keyframeanimation

import android.content.Context
import android.view.animation.AnticipateOvershootInterpolator
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager

fun Context.swapFrames(
    constraintLayout: ConstraintLayout,
    isLayout: Boolean,
    @LayoutRes layout1: Int,
    @LayoutRes layout2: Int,
) = ConstraintSet().also {
    it.clone(this, if (isLayout) layout1 else layout2)

    ChangeBounds().apply {
        interpolator = AnticipateOvershootInterpolator(1.0f)
        duration = 1200

        TransitionManager.beginDelayedTransition(constraintLayout, this)
    }

    it.applyTo(constraintLayout)
}
