package com.example.dynamicautocompletetextview

import android.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autotextView = AutoCompleteTextView(this)
        val button = Button(this)

        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        autotextView.layoutParams = layoutParams
        button.layoutParams = layoutParams
        layoutParams.setMargins(30, 30, 30, 30)
        autotextView.setHint(R.string.hint)
        button.setText("Submit")

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        linearLayout?.addView(autotextView)
        linearLayout?.addView(button)

        val languages = resources.getStringArray(R.array.Languages)

        val adapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , languages)
        autotextView.setAdapter(adapter)

        if (button != null) {
            button?.setOnClickListener(View.OnClickListener {
                val enteredText = getString(R.string.submitted_language) + " " +
                        autotextView.getText()
                Toast.makeText(this@MainActivity, enteredText, Toast.LENGTH_SHORT).show()
            })


        }
    }
}