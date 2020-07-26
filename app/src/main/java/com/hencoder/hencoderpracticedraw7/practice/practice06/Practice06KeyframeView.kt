package com.hencoder.hencoderpracticedraw7.practice.practice06

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw7.Utils

class Practice06KeyframeView : View {
    val radius = Utils.dpToPixel(80f)
    var progress = 0f
    set(value) {
        field = value
        invalidate()
    }
    var arcRectF = RectF()
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2.toFloat()
        val centerY = height / 2.toFloat()
        paint.color = Color.parseColor("#E91E63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = Utils.dpToPixel(15f)
        arcRectF[centerX - radius, centerY - radius, centerX + radius] = centerY + radius
        canvas.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawText("${progress.toInt()}%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint)
    }

    init {
        paint.textSize = Utils.dpToPixel(40f)
        paint.textAlign = Paint.Align.CENTER
    }
}