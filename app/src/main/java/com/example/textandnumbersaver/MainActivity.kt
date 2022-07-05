package com.example.textandnumbersaver

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import com.example.textandnumbersaver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickListeners()

    }

    private fun onClickListeners() {
        binding.addFieldButton.setOnClickListener {
            val isNumeric = binding.isNumericCheckBox.isChecked
            addFieldToContainer(createCustomEditText(this, isNumeric), binding.fieldsContainer)
        }
    }

    private fun createCustomEditText(context: Context, isNumeric: Boolean): EditText {
        val editText = EditText(context)
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        lp.setMargins(0, 16, 0, 16)
        editText.apply {
            hint = if (isNumeric) "Numeric" else "Text"
            inputType = if (isNumeric) InputType.TYPE_CLASS_NUMBER else InputType.TYPE_CLASS_TEXT
            setPadding(30)
            setBackgroundColor(Color.WHITE)
        }
        editText.layoutParams = lp
        return editText
    }

    private fun addFieldToContainer(editText: EditText, container: LinearLayout) {
        container.addView(editText)
    }

}