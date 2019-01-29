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
            val downloadBTN = it as DownloadButton

            val anim = ObjectAnimator.ofFloat(downloadBTN, DownloadButton.PROGRESS, 0f, 100f).setDuration(10100)

            when(downloadBTN.mState) {
                DownloadButton.STATE_NORMAL-> {
                    anim.start()
                    downloadBTN.mState = DownloadButton.STATE_DOWNLOADING
                }
                DownloadButton.STATE_DOWNLOADING-> {
                    anim.pause()
                    downloadBTN.mState = DownloadButton.STATE_PAUSED
                }
                DownloadButton.STATE_PAUSED-> {
                    anim.resume()
                    downloadBTN.mState = DownloadButton.STATE_DOWNLOADING
                }
            }
        }

        btn_download.setOnClickListener(onClick)
        btn_download1.setOnClickListener(onClick)
        btn_download2.setOnClickListener(onClick)

        btn.setOnClickListener {
            btn_download.mState = DownloadButton.STATE_NORMAL
            btn_download1.mState = DownloadButton.STATE_NORMAL
            btn_download2.mState = DownloadButton.STATE_NORMAL


        }

    }
}
