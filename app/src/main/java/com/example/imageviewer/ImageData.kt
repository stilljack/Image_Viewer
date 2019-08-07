package com.example.imageviewer

import android.net.Uri
import java.io.Serializable

class ImageData(fullPhotoUri: Uri) : Serializable {


        var name: String? = null
        var description: String? = null
        val fileUriString: String



    val fileUri: Uri
        get() = Uri.parse(fileUriString)
    //gets raw URI string from FileUriStrong designates it a URI jss

    init {

        this.fileUriString = fullPhotoUri.toString()
        //not going to pretend to understand in depth why this works but looks like a regular expression
        //to snag the file name off the end of URI -- one day I'll have magic powers if i keep trying
        val path = fullPhotoUri.path!!.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        this.name = path[path.size - 1]
        //AFAICT this gets the second to last chunk of path to find the name of the file jss
        this.description = ""
    }
}

