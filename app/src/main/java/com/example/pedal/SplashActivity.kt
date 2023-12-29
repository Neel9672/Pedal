package com.example.pedal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        videoView = findViewById(R.id.videoView)

        // Set the path to your video file
        val videoPath = "android.resource://" + packageName + "/" + R.raw.your_video // Replace with your video resource

        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        // Set media controller to enable play, pause, etc.
        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        // Start playing the video
        videoView.start()

        // Set a listener to transition to the main activity when the video finishes
        videoView.setOnCompletionListener {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, PhoneActivity::class.java)
        startActivity(intent)
        finish()
    }
}