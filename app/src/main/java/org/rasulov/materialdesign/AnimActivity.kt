package org.rasulov.materialdesign

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
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

        var counter = 0

        binding.apply {
            btnStart.setOnClickListener { _ ->
                counter += 1

                Log.d("it0088", "onCreate: ${btnStart.translationY}")
                Log.d("it0088", "onCreate: ${btnStart.y}")
                Log.d("it0088", "onCreate: ${btnStart.scaleX}")

                val translate = ObjectAnimator.ofFloat(
                    btnStart, "translationY", (100f * counter)
                )

                val scale = ObjectAnimator.ofFloat(
                    btnStart, "scaleX", (1f * counter)
                )

                val color = ObjectAnimator.ofObject(
                    btnStart, "textColor", ArgbEvaluator(), Color.RED, Color.GREEN
                )

                AnimatorSet().apply {
                    playTogether(translate, scale, color)
                    duration = 1000
                    addListener(onEnd = {
                        Log.d("it0088", "onCreate: ${btnStart.translationY}")
                        Log.d("it0088", "onCreate: ${btnStart.y}")
                        Log.d("it0088", "onCreate: ${btnStart.scaleX}")
                    })
                }.start()

            }
        }

    }
}