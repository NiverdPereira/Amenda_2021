package com.example.amenda

import android.annotation.SuppressLint
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

    var binding: ActivityMainBinding? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setActionBar()
        setImageListener()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setActionBar() {
        val toolBar: Toolbar = findViewById(R.id.toolbar)
        toolBar.apply {
            title = "Pudding Who?"
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
            when (toolBar.title) {
                "Pudding Who?" -> toolBar.title = "Amenda"
                "Amenda" -> toolBar.title = "What else?"
                "What else?" -> toolBar.title = "Birthday girl"
                else -> toolBar.title = "Pudding Who?"
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    private fun setImageListener() {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        val date = sdf.parse("19/07/2021")
        binding?.one?.setOnClickListener {
            if (Date().after(date)) {
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
}