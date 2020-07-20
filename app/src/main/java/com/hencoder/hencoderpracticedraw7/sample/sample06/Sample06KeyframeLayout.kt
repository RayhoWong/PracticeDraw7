package com.hencoder.hencoderpracticedraw7.sample.sample06

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw7.R

class Sample06KeyframeLayout : RelativeLayout {
    var view: Sample06KeyframeView? = null
    var animateBt: Button? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        view = findViewById(R.id.objectAnimatorView) as Sample06KeyframeView
        animateBt = findViewById(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            val keyframe1 = Keyframe.ofFloat(0f, 0f) // 开始：progress 为 0
            val keyframe2 = Keyframe.ofFloat(0.5f, 100f) // 进行到一半是，progres 为 100
            val keyframe3 = Keyframe.ofFloat(1f, 80f) // 结束时倒回到 80
            val holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3)
            val animator = ObjectAnimator.ofPropertyValuesHolder(view, holder)
            animator.duration = 2000
            animator.interpolator = FastOutSlowInInterpolator()
            animator.start()
        }
    }
}