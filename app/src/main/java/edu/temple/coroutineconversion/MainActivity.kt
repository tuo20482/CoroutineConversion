package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    private lateinit var cakeImageView: ImageView
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener{
            scope.launch {
                for (i in 0..100) {
                    cakeImageView.alpha = i / 100f
                    delay(40)
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}