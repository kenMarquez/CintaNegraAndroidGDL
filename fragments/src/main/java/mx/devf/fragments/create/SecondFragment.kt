package mx.devf.fragments.create

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.devf.fragments.R

/**
 * Created by ken on 02/10/17.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_second, container, false)
        return view
    }


}