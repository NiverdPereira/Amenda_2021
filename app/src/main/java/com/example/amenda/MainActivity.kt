package com.example.amenda

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import com.example.amenda.databinding.ActivityMainBinding
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val heyPudding = "HEY PUDDING"
    private val hBD = "HAPPY BIRTHDAY AND....."
    private val youKnow = "YOU KNOW..."
    private val iLY = "I LOVE YOU"

    var binding: ActivityMainBinding? = null
    private var media: MediaPlayer? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setActionBar()
        setImageListener()
        media = MediaPlayer.create(this, R.raw.music)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setActionBar() {
        val toolBar: Toolbar = findViewById(R.id.toolbar)
        toolBar.apply {
            title = heyPudding
            titleMarginStart = 20
            subtitle = "Click me"
            setSubtitleTextColor(getColor(R.color.white))
            setTitleTextColor(getColor(R.color.white))
            setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark, null))
        }
        val actionBar = supportActionBar
        actionBar?.apply {
            customView = toolBar
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setDisplayShowCustomEnabled(true)
            setHomeAsUpIndicator(R.drawable.feb21_2021)
        }
        toolBar.setOnClickListener {
            if (isBirthday()) {
                when (toolBar.title) {
                    heyPudding -> toolBar.title = hBD
                    hBD -> toolBar.title = youKnow
                    youKnow -> toolBar.title = iLY
                    else -> toolBar.title = heyPudding
                }
            } else {
                toolBar.title = "Come back when it is your birthday pudding"
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    private fun setImageListener() {
        binding?.one?.setOnClickListener {
            if (isBirthday()) {
                if (media?.isPlaying == true) {
                    media?.stop()
                }
                else if (media?.isPlaying == false) {
                    media?.start()
                }
                binding?.images?.visibility = View.VISIBLE
                binding?.click?.visibility = View.GONE
            } else {
                binding?.click?.apply {
                    text = "Hey its not your birthday yet! PATIENCE HONEY"
                    setTextColor(getColor(android.R.color.holo_red_dark))
                }
            }
        }
    }

    private fun isBirthday(): Boolean {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        val date = sdf.parse("19/07/2021")
        return Date().after(date)
    }
}