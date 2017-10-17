package mx.devf.navigationview

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar


class TabsActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var tabLayout: TabLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        var toolbar: Toolbar? = findViewById(R.id.toolbar) as Toolbar
        viewPager = findViewById(R.id.viewpager) as ViewPager
        tabLayout = findViewById(R.id.tabs) as TabLayout

        setSupportActionBar(toolbar)
        supportActionBar?.title = "App Name"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewPager()

    }

    fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PrimerFragment(), "Primero")
        adapter.addFragment(SegundoFragment(), "Segundo")
        adapter.addFragment(PrimerFragment(), "Primero")

        viewPager?.adapter = adapter

        tabLayout?.setupWithViewPager(viewPager)
    }


}
