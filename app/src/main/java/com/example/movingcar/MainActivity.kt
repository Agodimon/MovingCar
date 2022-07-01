package com.example.movingcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movingcar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)
    private var isMoved: Boolean = true
    private val anim: CarAnimation by lazy {
        CarAnimation(
            maxYOfScreen = viewBinding.root.height.toFloat(),
            maxXOfScreen = viewBinding.root.width.toFloat(),
            view = viewBinding.speedCar,
            interpolator = OvershootInterpolator()
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initView()
    }
    private fun initView() {
        viewBinding.speedCar.setOnClickListener {
            onStartAnimation()
        }
    }


    private fun onStartAnimation() {
        isMoved = !isMoved
        anim.onStartAnimation(650, 0f, isMoved)
    }
}