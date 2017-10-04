package mx.devf.fragments.interfaces

import android.util.Log
import mx.devf.fragments.OnFragmentInteractionListener

/**
 * Created by ken on 03/10/17.
 */

class Mustang : Vehiculo {


    override fun avanzar() {
        Log.e("myLog", "rrrrun rrrrrun")
    }

    override fun frenar() {

    }

    override fun pitar() {

    }

    fun algo(listener: OnFragmentInteractionListener) {
        listener.onInteraction("hola")
    }

}
