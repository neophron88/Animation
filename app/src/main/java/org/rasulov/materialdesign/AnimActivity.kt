package org.rasulov.materialdesign

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import org.rasulov.materialdesign.databinding.ActivityAnimBinding

class AnimActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAnimBinding.inflate(layoutInflater).also { setContentView(it.root) }


        binding.btnStart.setOnClickListener { _ ->
            val animation = binding.checkmark.background as AnimatedVectorDrawable
            animation.start()
        }

    }
}