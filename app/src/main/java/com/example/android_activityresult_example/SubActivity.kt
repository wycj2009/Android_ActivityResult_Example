package com.example.android_activityresult_example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_activityresult_example.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_RESULT = "RESULT"
    }

    class ResultContract : ActivityResultContract<Unit, String?>() {
        override fun createIntent(context: Context, input: Unit?): Intent {
            return Intent(context, SubActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            return when (resultCode) {
                RESULT_OK -> intent?.getStringExtra(EXTRA_RESULT)
                else -> null
            }
        }
    }

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub)

        binding.back.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra(EXTRA_RESULT, binding.data.text.toString()))
            finish()
        }
    }

}