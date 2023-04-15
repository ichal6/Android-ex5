package pl.lechowicz.android_v

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        editText = findViewById(R.id.editText)
        saveButton = findViewById(R.id.saveButton)

        if (sharedPreferences.contains("text")) {
            editText.setText(sharedPreferences.getString("text", ""))
        } else {
            editText.setText("")
        }

        saveButton.setOnClickListener {
            val text = editText.text.toString()
            sharedPreferences.edit().putString("text", text).apply()
            Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
        }
    }
}
