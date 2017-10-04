package mx.devf.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import mx.devf.fragments.interfaces.Mustang

class InteractionActivity : AppCompatActivity(), OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interaction_frag)
        val fragment = IteractionFragment.newInstance("Hola desde la actividad", R.drawable.homero)
        changeFragment(fragment)

    }

    /**
     * Cambiamos dinamicante fragmento recibido como parametro
     */
    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment,"frag1")
                .commit()
    }


    override fun onInteraction(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        val fragment = supportFragmentManager.findFragmentByTag("frag1") as IteractionFragment;
        fragment.mostrarMensajeVuelta("Mensaje de vuelta")

    }


}
