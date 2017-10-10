package mx.devf.fragments.ejercicio

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mx.devf.fragments.R

/**
 * Created by ken on 09/10/17.
 */
class ContadorFragment : Fragment(), View.OnClickListener {


    var resColor = 0

    var contador: Int = 0
    var tvContador: TextView? = null
    var listener: OnFragmentInteraction? = null

    companion object {

        val ARG_COLOR = "ARG_COLOR"


        fun newInstance(resColor: Int): ContadorFragment {
            //Creao una indstancia de Contador fragment
            val fragment = ContadorFragment()
            //Creo el bundle donde guardare los datos que pasare como argumentos
            val args = Bundle()
            args.putInt(ARG_COLOR, resColor)
            //Asocio mi bundle a mi fragmento
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteraction)
            listener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resColor = arguments.getInt(ARG_COLOR)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_contador, container, false)

        //Obtengo la referencia a mi fragmento que esta en mi actividad
        val layout = view.findViewById<View>(R.id.root_layout)
        layout.setBackgroundResource(resColor)
        layout.setOnClickListener(this)

        tvContador = view.findViewById<TextView>(R.id.tv_count)
        tvContador!!.text = "0"


        return view;
    }


    fun incrementar() {
        tvContador!!.text = "" + contador++
    }

    override fun onClick(p0: View?) {
        listener?.onFragmentClickListener(tag)
    }

    /**
     * Interfaz que me ayudará a interactuar mi fragmento con
     * las clases que implementen esta interfaz
     */
    interface OnFragmentInteraction {

        fun onFragmentClickListener(tagFragment: String)
    }

}