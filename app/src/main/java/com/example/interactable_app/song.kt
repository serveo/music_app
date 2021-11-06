package com.example.interactable_app

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import com.example.interactable_app.databinding.ActivityMainBinding
import com.example.interactable_app.databinding.ActivitySongBinding

class song : AppCompatActivity() {
    private lateinit var binding : ActivitySongBinding
    private lateinit var runnable: Runnable
    private  var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        val mediaPlayer = MediaPlayer.create(this,R.raw.song)
        binding.seekBar.progress = 0
        binding.seekBar.max = mediaPlayer.duration
        binding.play.setOnClickListener{
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
                binding.play.setBackgroundResource(R.drawable.pause)
            }else{
                mediaPlayer.pause()
                binding.play.setBackgroundResource(R.drawable.play)
            }
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        runnable = Runnable {
            binding.seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.pause()
            binding.play.setBackgroundResource(R.drawable.play)
        }

        binding.replay.setOnClickListener(){
            mediaPlayer.pause()
            mediaPlayer.seekTo(0)
            mediaPlayer.start()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}