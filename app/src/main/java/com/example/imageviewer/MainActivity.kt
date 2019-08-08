package com.example.imageviewer

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        internal const val REQUEST_IMAGE_GET = 1
        internal const val DETAIL_IMAGE_REQUEST = 2
        var imageList: ArrayList<ImageData> = ArrayList()
        var index1 = 0

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

 /*   fun sendDetails(index: Int, img: ImageData ): Intent {
        val intent = Intent(this, ImageData::class.java)
        intent.putExtra(DETAIL_IMAGE_REQUEST, )
        return intent
    }*/
    fun createTextView(string: String?, int: Int): TextView {
        val view = TextView(this)
     view.tag = imageList[int]
        view.text = string
        view.textSize = 24f

        view.setOnClickListener {

            val intent = Intent(this, ImageData::class.java)
            intent.putExtra("extra_object", imageList[int])
            startActivity(intent)
            }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val fullPhotoUri: Uri? = data!!.data
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            imageList.add(ImageData(fullPhotoUri))
            picture_linear_layout.addView(createTextView(ImageData(fullPhotoUri).name, index1++)

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




