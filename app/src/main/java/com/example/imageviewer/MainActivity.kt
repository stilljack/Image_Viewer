package com.example.imageviewer

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    companion object {
        internal const val REQUEST_IMAGE_GET = 1
        internal const val DETAIL_IMAGE_REQUEST = 2
        var imageList: ArrayList<ImageData> = ArrayList()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_GET)
            }


        }


    }


    fun createTextView(string: String?, int: Int): TextView {
        val view = TextView(this)

        view.text = string
        view.textSize = 24f
        view.tag = string!!.toUri()
        view.setOnClickListener {
            //            val image =
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, DETAIL_IMAGE_REQUEST)
            }
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val fullPhotoUri: Uri? = data!!.data
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            imageList.add(ImageData(fullPhotoUri))
            picture_linear_layout.addView(createTextView(ImageData(fullPhotoUri).name, index)
            )
        } else if (requestCode == DETAIL_IMAGE_REQUEST && resultCode == RESULT_OK) {
            // Make sure the request was successful
            val returnedData = data!!.getSerializableExtra("object") as ImageData

            for (i in 0..imageList.size) {
                if (imageList[i].fileUriString == returnedData.fileUriString) {
                    imageList[i] = returnedData
                }
            }

/*

 */
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}




