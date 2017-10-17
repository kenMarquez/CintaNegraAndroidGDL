package mx.devf.quizapp

import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import mx.devf.quizapp.fragments.QuestionFragment
import mx.devf.quizapp.utils.Constants
import java.util.*

class PlayActivity : AppCompatActivity(), View.OnClickListener {


    private val list = Arrays.asList("Pregunta 1", "Pregunta 2", "Pregunta 3", "Pregunta 4",
            "Pregunta 5")

    private var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        setupViews()
        initGame()

    }

    private fun initGame() {
        //Cargamos el fragmento inicial.
        changeFragment("Pregunta inicial")


    }

    private fun setupViews() {
        //Obtenemos el valor del username pasado en la actividad anterior
        val username = intent.extras?.getString(Constants.INTENT_KEY_USERNAME)

        //Inicializamos el Textview del username
        val tvUsername = findViewById(R.id.tv_username) as TextView
        //Asignamos el username al textview
        tvUsername.text = "Bienvenido $username"

        findViewById(R.id.img_arrow_right).setOnClickListener(this)
    }

    /**
     * Función que me permite cambiar de fragmento
     */
    private fun changeFragment(title: String) {
        val contadorFragment = QuestionFragment.newInstance(title)
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, contadorFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    override fun onClick(view: View?) {
        if (count < list.size) {
            changeFragment(list.get(count++))
        }
    }


}
