package com.example.imageviewer

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.imageviewer.MainActivity.Companion.imageList

import kotlinx.android.synthetic.main.activity_details.*

class details (imageData: ImageData) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)

        val returnedData = intent.getSerializableExtra("extra_object" as ImageData)
        for (i in 0 .. MainActivity.imageList.size) {
            if (ImageData(imageList[i].) == returnedData.) {
                imageList[i] = returnedData
            }
        }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
