package mx.devf.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


/**
 * Created by ken on 02/10/17.
 */
class IteractionFragment : Fragment(), View.OnClickListener {


    var texto: String? = null
    var imgResource: Int? = null
    var callback: OnFragmentInteractionListener? = null

    companion object {

        val ARG_TXT = "ARG_TXT"
        val ARG_IMG = "ARG_IMG"

        fun newInstance(text: String, imgResource: Int): IteractionFragment {
            //Creo una instancia de IteractionFragment
            val fragment = IteractionFragment()
            //Creo un bundle que guardara los datos pasados como argumentos en mi fragmento
            val args = Bundle()
            //le paso los parametros al bundle
            args.putString(ARG_TXT, text)
            args.putInt(ARG_IMG, imgResource)
            //Asocio mi bundle a mi fragmento
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Recupero los argumentos del Bundle
        texto = arguments.getString(ARG_TXT)
        imgResource = arguments.getInt(ARG_IMG)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_iteraction, container, false);
        val tvText = view.findViewById<TextView>(R.id.tv_text)
        tvText.text = texto

        val img = view.findViewById<ImageView>(R.id.img)
        img.setImageResource(imgResource!!)



        view.findViewById<Button>(R.id.btn).setOnClickListener(this)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            callback = context as OnFragmentInteractionListener
        }
    }


    fun mostrarMensajeVuelta(messageFromActivity: String) {
        Toast.makeText(activity, messageFromActivity, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {
        callback?.onInteraction("Hola desde el fragmento a la actividad")
    }


}