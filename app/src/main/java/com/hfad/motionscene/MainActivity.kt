package com.hfad.motionscene

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.hfad.motionscene.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            motionLayout.setTransitionListener(object : TransitionAdapter() {
                override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                    when (currentId) {
                        R.id.offScreenPass -> {
                            Toast.makeText(this@MainActivity, "pass", Toast.LENGTH_SHORT).show()
                            motionLayout.progress = 0f
                            motionLayout.setTransition(R.id.rest, R.id.like)
                        }

                        R.id.offScreenLike -> {
                            Toast.makeText(this@MainActivity, "like", Toast.LENGTH_SHORT).show()
                            motionLayout.progress = 0f
                            motionLayout.setTransition(R.id.rest, R.id.like)
                        }
                    }
                }
            })
        }
    }
}