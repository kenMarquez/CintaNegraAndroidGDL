package mx.devf.intents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val message = intent.extras.get("key1")
        val numero = intent.extras.get("key2")
        val nusda = intent.extras.get("key2234")

        Log.d("myLog", "Message: $message")
        Log.d("myLog", "Numero: $numero")


    }




}
