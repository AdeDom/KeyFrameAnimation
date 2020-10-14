package com.adedom.keyframeanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.state.observe { state ->
            swapFrames(constraintLayout, state.isLayout, R.layout.activity_main, R.layout.activity_main_detail)
        }

        constraintLayout.setOnClickListener {
            viewModel.changeLayout()
        }
    }

    private inline fun <reified T> LiveData<T>.observe(crossinline onNext: (T) -> Unit) {
        observe(this@MainActivity, { onNext(it) })
    }

}
