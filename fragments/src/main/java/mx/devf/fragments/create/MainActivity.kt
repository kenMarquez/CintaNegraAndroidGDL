package mx.devf.fragments.create

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import mx.devf.fragments.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val layoutContainer = findViewById(R.id.content)

        /**
         * Conseguimos la orientación del dispositivo
         * si es 1 esta en vertical
         * 2 horizontal
         */
        val orientation = resources.configuration.orientation

        if (orientation == 1) {
            layoutContainer.visibility = View.GONE
        } else {
            val fragment = ThirdFragment()
            val fragmentManager = supportFragmentManager

            fragmentManager.beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit()
        }


    }


}
