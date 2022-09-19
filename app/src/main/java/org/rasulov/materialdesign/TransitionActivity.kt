package org.rasulov.materialdesign

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import org.rasulov.materialdesign.databinding.FirstLayoutBinding

class TransitionActivity : AppCompatActivity() {

    private val binding: FirstLayoutBinding by viewBindings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            startbtnT.setOnClickListener {


                Log.d("it0088", "onCreate: ${startbtnT.textSize}")
                Log.d("it0088", "onCreate: ${startbtnT.x}")
                Log.d("it0088", "onCreate: ${startbtnT.y}")

                val translate = ChangeBounds()
                val fade = Fade()
                val transition = TransitionSet()
                        .addTransition(translate)
                        .addTransition(fade)
                        .setDuration(1000)

                val scene = Scene.getSceneForLayout(
                    binding.root,
                    R.layout.second_layout,
                    this@TransitionActivity
                )

                TransitionManager.go(scene, transition)
            }
        }

    }
}