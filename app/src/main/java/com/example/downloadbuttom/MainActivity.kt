package com.example.downloadbuttom

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val onClick = View.OnClickListener {
            val downloadBTN = it as TextProgressBar

            val anim = ObjectAnimator.ofFloat(downloadBTN, TextProgressBar.PROGRESS, 0f, 100f).setDuration(10100)

            when(downloadBTN.mState) {
                TextProgressBar.STATE_NORMAL-> {
                    anim.start()
                    downloadBTN.mState = TextProgressBar.STATE_DOWNLOADING
                }
                TextProgressBar.STATE_DOWNLOADING-> {
                    anim.pause()
                    downloadBTN.mState = TextProgressBar.STATE_PAUSED
                }
                TextProgressBar.STATE_PAUSED-> {
                    anim.resume()
                    downloadBTN.mState = TextProgressBar.STATE_DOWNLOADING
                }
            }
        }

        btn_download.setOnClickListener(onClick)
        btn_download1.setOnClickListener(onClick)
        btn_download2.setOnClickListener(onClick)

        btn.setOnClickListener {
            btn_download.mState = TextProgressBar.STATE_NORMAL
            btn_download1.mState = TextProgressBar.STATE_NORMAL
            btn_download2.mState = TextProgressBar.STATE_NORMAL


        }

    }
}
