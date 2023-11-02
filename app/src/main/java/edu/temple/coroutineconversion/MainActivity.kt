package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    private lateinit var cakeImageView: ImageView

    private val handler = Handler(Looper.getMainLooper()) {
        cakeImageView.alpha = it.what / 100f
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener{
            Thread{
                repeat(100) {
                    handler.sendEmptyMessage(it)
                    Thread.sleep(40)
                }
            }.start()
        }
    }
}