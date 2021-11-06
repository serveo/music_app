package com.example.interactable_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class Video : AppCompatActivity() {

    var simpleVideoView: VideoView? = null

    var mediaControls: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        simpleVideoView = findViewById<View>(R.id.videoView) as VideoView

        if (mediaControls == null) {
            mediaControls = MediaController(this)
            mediaControls!!.setAnchorView(this.simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaControls)
        simpleVideoView!!.setVideoURI(Uri.parse("android.resource://"
                + packageName + "/" + R.raw.videoplayback))

        simpleVideoView!!.requestFocus()
        simpleVideoView!!.start()

        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed",
                Toast.LENGTH_LONG).show()
        }


    }
}

