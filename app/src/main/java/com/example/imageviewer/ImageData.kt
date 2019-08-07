package com.example.imageviewer

import android.net.Uri
import java.io.Serializable
import java.net.URI

class ImageData (imageURI: URI) : Serializable {

    val fileURIString: String  = imageURI.toString()
    val fileUri: Uri
        get() = Uri.parse(fileURIString)

}

