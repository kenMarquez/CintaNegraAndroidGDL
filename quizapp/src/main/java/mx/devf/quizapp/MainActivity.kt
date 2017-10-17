package mx.devf.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import mx.devf.quizapp.utils.Constants

class MainActivity : AppCompatActivity(), View.OnClickListener {


    /**
     * Vistas con las que iteractura el usuario
     */
    var inputUserName: EditText? = null
    var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referenciamos las vistas que ocupamos de nuestro xml
        fab = findViewById(R.id.fab_continuar) as FloatingActionButton
        inputUserName = findViewById(R.id.input_username) as EditText
    }

    override fun onStart() {
        super.onStart()
        //le asignamos un escuchador que se mandara a llamar cuando le demos click a nuestro btn
        fab?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        //Tomamos lo que esta dentro de nuestro EditText
        val userName = inputUserName?.text.toString()

        //validamos que el usuario ingreso su username
        if (userName.isEmpty()) {
            //Le mandamos un mensaje de que el campo no puede ser vacio
            Toast.makeText(this, R.string.error_empty_input, Toast.LENGTH_SHORT).show()
        } else {

            //Lo mandamos a la pantalla de juego
            val intent = Intent(this, PlayActivity::class.java)
            intent.putExtra(Constants.INTENT_KEY_USERNAME, userName)
            startActivity(intent)

        }


    }


}


