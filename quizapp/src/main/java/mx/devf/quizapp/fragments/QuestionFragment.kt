package mx.devf.quizapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mx.devf.quizapp.R

/**
 * Created by ken on 11/10/17.
 */
class QuestionFragment : Fragment(), View.OnClickListener {


    var title: String? = null
    private var tvFalse: TextView? = null
    private var tvTrue: TextView? = null

    var respuesta = -1

    companion object {

        val ARG_TITLE = "ARG_TITLE"

        fun newInstance(title: String): QuestionFragment {
            //Creo la instancia de mi fragmento
            val fragment = QuestionFragment()
            //Creo un bundle que me servirá para guardar los parametros
            val extras = Bundle()
            //Guardamos en el bundle la variable title
            extras.putString(ARG_TITLE, title)
            //Asignamos nuestro bundle al fragmento
            fragment.arguments = extras
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(ARG_TITLE)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_question, container, false)


        val tvTitle = view.findViewById<TextView>(R.id.tv_question_title)
        tvTitle.setText(title)

        /**
         * Referenciamos las vistas de false y true
         */
        tvFalse = view.findViewById<TextView>(R.id.question_tv_false) as TextView
        tvTrue = view.findViewById<TextView>(R.id.question_tv_true) as TextView

        /**
         * Asignamos escuchadores a los botones de false y true
         */
        tvFalse?.setOnClickListener(this)
        tvTrue?.setOnClickListener(this)



        return view
    }

    override fun onClick(view: View) {
        /**
         * Swich de las vistas que asignamos el escuchador
         */
        when (view.id) {
            R.id.question_tv_false -> {
                respuesta = 0
                tvTrue?.setBackgroundResource(R.color.btn_unselected)
                tvFalse?.setBackgroundResource(R.color.btn_selected)
            }
            R.id.question_tv_true -> {
                respuesta = 1
                tvTrue?.setBackgroundResource(R.color.btn_selected)
                tvFalse?.setBackgroundResource(R.color.btn_unselected)
            }
        }
    }

}