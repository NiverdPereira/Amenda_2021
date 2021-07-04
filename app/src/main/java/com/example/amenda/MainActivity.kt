package com.example.amenda

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import com.example.amenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setActionBar()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setActionBar() {
        val toolBar: Toolbar = findViewById(R.id.toolbar)
        toolBar.setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark, null))
        val actionBar = supportActionBar
        actionBar?.customView = toolBar
        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.setDisplayShowCustomEnabled(true)
    }
}