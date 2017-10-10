package mx.devf.fragments.ejercicio

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mx.devf.fragments.R

class ContadorActivity : AppCompatActivity(), ContadorFragment.OnFragmentInteraction {

    val TAG_CONTADOR1 = "ADFASD"
    val TAG_CONTADOR2 = "CONTADOR2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)
        cargarContador1()
        cargarContador2()


    }


    private fun cargarContador1() {
        val contadorFragment = ContadorFragment.newInstance(R.color.colorAccent)
        supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout1, contadorFragment, TAG_CONTADOR1)
                .commit()
    }

    private fun cargarContador2() {
        val contadorFragment = ContadorFragment.newInstance(R.color.colorPrimary)
        supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout2, contadorFragment, TAG_CONTADOR2)
                .commit()
    }

    override fun onFragmentClickListener(tagFragment: String) {
        when (tagFragment) {
            TAG_CONTADOR1 -> incrementarFragment(TAG_CONTADOR2)
            TAG_CONTADOR2 -> incrementarFragment(TAG_CONTADOR1)
        }
    }

    private fun incrementarFragment(tag: String) {
        var fragment = supportFragmentManager.findFragmentByTag(tag) as ContadorFragment
        fragment?.incrementar()
    }


}
