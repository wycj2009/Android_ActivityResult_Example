package com.example.android_activityresult_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_activityresult_example.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val subLauncher = registerForActivityResult(SubActivity.ResultContract()) {
        if (!it.isNullOrEmpty())
            Snackbar.make(this@MainActivity, binding.root, it, Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            subLauncher.launch(Unit)
        }
    }

}