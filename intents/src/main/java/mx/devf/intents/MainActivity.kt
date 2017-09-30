package mx.devf.intents

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var imgPicture: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById(R.id.btn_open_activity).setOnClickListener(this)
        findViewById(R.id.btn_call).setOnClickListener(this)
        findViewById(R.id.btn_open_link).setOnClickListener(this)
        findViewById(R.id.btn_street_view).setOnClickListener(this)
        findViewById(R.id.btn_take_picture).setOnClickListener(this)

        imgPicture = findViewById(R.id.img_picture) as ImageView


    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.btn_open_activity -> openActivity()
            R.id.btn_call -> doCall()
            R.id.btn_open_link -> openLink()
            R.id.btn_street_view -> abrirStreetView()
            R.id.btn_take_picture -> takePicture()

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1032) {
            if (resultCode == Activity.RESULT_OK) {
                val photo = data?.extras?.get("data") as Bitmap
                imgPicture?.setImageBitmap(photo)
            } else {
                Toast.makeText(this, "Cancelo tomar foto", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun openMap(view: View?) {
        val direction = "http://maps.google.com/maps?saddr=20.6488206&daddr=-103.4063073,15.26"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(direction))
        startActivity(intent)
    }

    fun abrirStreetView() {
        val gmmIntentUri = Uri.parse("google.streetview:cbll=20.6488206,-103.4063073")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.`package` = "com.google.android.apps.maps"
        startActivity(mapIntent)
    }


    fun takePicture() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 1032)
    }


    private fun openLink() {
        val url = "http://www.google.com"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun doCall() {
        //Configuramos el intent pasandole el class de la actividad a la que nos dirigimos
        var intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "5537901848"))
        startActivity(intent)
    }


    fun openActivity() {
        //Configuramos el intent pasandole el class de la actividad a la que nos dirigimos
        val intent = Intent(this, ThirdActivity::class.java)

        //Ingresamos parametros que se pasaran a la sig. actividad
        intent.putExtra("key1", "Pasando datos ")
        intent.putExtra("key2", 1938)

        //Ejecutamos el intent
        startActivity(intent)
    }


}
