package com.example.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun addTextView (text) {
        for(i in 0..9) {
            val view = createTextView(itemList[i], userList[i])
            picture_linear_layout.addView(view)
        }
    }
    fun createTextView(item: String, user: Int): TextView {
        val view = TextView(this)

        view.text = "${item.name} - ${item.price}, ${user.location}, ${user.reputation}"
        view.textSize = 24f

        return view
    }
}
