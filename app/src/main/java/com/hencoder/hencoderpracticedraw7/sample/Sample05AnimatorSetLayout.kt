package com.hencoder.hencoderpracticedraw7.sample

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw7.R

class Sample05AnimatorSetLayout : RelativeLayout {
    var view: View? = null
    var animateBt: Button? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        view = findViewById(R.id.objectAnimatorView)
        animateBt = findViewById(R.id.animateBt) as Button
        animateBt!!.setOnClickListener {
            view.run { setTranslationX(-200f) }
            val animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
            val animator2 = ObjectAnimator.ofFloat(view, "translationX", -200f, 200f)
            val animator3 = ObjectAnimator.ofFloat(view, "rotation", 0f, 1080f)
            animator3.duration = 1000
            val animatorSet = AnimatorSet()
            animatorSet.play(animator1).before(animator2) // 先执行 1 再执行 2
            animatorSet.playTogether(animator2, animator3) // 2 和 3 同时开始
            animatorSet.start()
        }
    }
}