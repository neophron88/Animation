package org.rasulov.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import org.rasulov.materialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBindings()

    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // Step 1: Create a Scene object for both the starting and ending layout
        scene1 = Scene.getSceneForLayout(binding.sceneRootFrameLayout, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(binding.sceneRootFrameLayout, R.layout.scene2, this)

        // Step 2: Create a Transition object to define what type of animation you want
        scene1.enter()
        currentScene = scene1

        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2)


        binding.sceneRootFrameLayout.setOnClickListener {

            currentScene = if (currentScene === scene1) {
                TransitionManager.go(scene2,transition)
                scene2
            } else {
                TransitionManager.go(scene1,transition)
                scene1
            }
        }
    }

}