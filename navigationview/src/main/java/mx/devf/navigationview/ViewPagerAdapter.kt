package mx.devf.navigationview

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by ken on 11/10/17.
 */
class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {


    val fragmentList = ArrayList<Fragment>()
    val titleList = ArrayList<String>()


    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }


    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

}