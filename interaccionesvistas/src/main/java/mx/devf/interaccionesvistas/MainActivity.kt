package mx.devf.interaccionesvistas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var tvName: TextView? = null;
    private var inputName: EditText? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tv_name) as TextView;
        tvName?.setOnClickListener(this)

        inputName = findViewById(R.id.editText) as EditText


        findViewById(R.id.button2).setOnClickListener(this)
    }


    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.tv_name -> {
                Toast.makeText(this, "textview", Toast.LENGTH_SHORT).show();

            }
            R.id.button2 -> {
                val txtName = inputName?.text.toString();
                tvName?.text = txtName;


                inputName?.texto("a")


                doAsync {


                }

            }

        }
    }


    fun EditText.texto(txt: String) {
        this.text = Editable.Factory.getInstance().newEditable(txt)
    }


}

