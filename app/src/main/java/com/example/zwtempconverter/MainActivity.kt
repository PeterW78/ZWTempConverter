package com.example.zwtempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cBar = findViewById<SeekBar>(R.id.cBar)
        val cTemp = findViewById<TextView>(R.id.cTemp)
        val fBar = findViewById<SeekBar>(R.id.fBar)
        val fTemp = findViewById<TextView>(R.id.fTemp)
        val message = findViewById<TextView>(R.id.message)

        cBar?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                val f = (progress * 9 / 5) + 32
                fBar.progress= f
                cTemp.text = progress.toString()
                fTemp.text = f.toString()
                if (progress <= 20)
                {
                    message.text = "I wish it were warmer"
                }
                else
                {
                    message.text = "I wish it were colder"
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                val temp = cTemp.text.toString().toInt()
                if (temp <= 20)
                {
                    message.text = "I wish it were warmer"
                }
                else
                {
                    message.text = "I wish it were colder"
                }
            }
        })

        fBar?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                if (progress < 32)
                {
                    fBar.progress = 32
                    cBar.progress = 0
                    fTemp.text = "32"
                    cTemp.text = "0"
                    message.text = "I wish it were warmer"
                }
                else {
                    val c = (progress - 32) * 5 / 9
                    cBar.progress = c
                    fTemp.text = progress.toString()
                    cTemp.text = c.toString()
                    if (c <= 20) {
                        message.text = "I wish it were warmer"
                    } else {
                        message.text = "I wish it were colder"
                    }
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })
    }
}