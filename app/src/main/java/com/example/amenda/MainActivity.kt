package com.example.amenda

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amenda.databinding.ActivityMainBinding
import com.google.accompanist.appcompattheme.AppCompatTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val heyPudding = "HEY PUDDING"
    private val hBD = "HAPPY BIRTHDAY AND....."
    private val youKnow = "YOU KNOW..."
    private val iLY = "I LOVE YOU"

    private var binding: ActivityMainBinding? = null
    private var media: MediaPlayer? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setActionBar()
        setImageListener()
        media = MediaPlayer.create(this, R.raw.music)

        binding?.click?.setContent {
            AppCompatTheme {
                Click(colors =  R.color.purple_500)
            }
        }
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
                } else if (media?.isPlaying == false) {
                    media?.start()
                }
                binding?.images?.visibility = View.VISIBLE
                binding?.click?.visibility = View.GONE
            } else {
                binding?.click?.setContent {
                    AppCompatTheme {
                        Click("Hey its not your birthday yet! PATIENCE HONEY", R.color.purple_500)
                    }
                }
            }
        }
    }

    @Composable
    private fun Click(text: String = stringResource(id = R.string.click_the_photo).uppercase(), colors: Int) {
        Text(
            text = text,
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .size(40.dp),
            color = colorResource(id = colors)
        )

    }

    private fun isBirthday(): Boolean {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        val date = sdf.parse("19/07/2021")
        return Date().after(date)
    }
}