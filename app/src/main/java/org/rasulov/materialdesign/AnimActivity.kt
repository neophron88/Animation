package org.rasulov.materialdesign

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.app.ActivityCompat
import org.rasulov.materialdesign.databinding.ActivityAnimBinding

class AnimActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAnimBinding.inflate(layoutInflater).also { setContentView(it.root) }


        var isTrue = true

        binding.checkmark.setOnClickListener { _ ->

            binding.checkmark.background = if (isTrue) {
                ActivityCompat.getDrawable(this, R.drawable.avd_heart_outline)
            } else {
                ActivityCompat.getDrawable(this, R.drawable.avd_heart_fill)
            }

            val animation = binding.checkmark.background as AnimatedVectorDrawable
            animation.start()
            isTrue = !isTrue
        }

    }
}