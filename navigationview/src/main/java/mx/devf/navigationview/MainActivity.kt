package mx.devf.navigationview

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    var mDrawerToggle: ActionBarDrawerToggle? = null

    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawer) as DrawerLayout
        navigationView = findViewById(R.id.navigationview) as NavigationView

        setupNavigationView()
    }

    private fun setupNavigationView() {
        mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        drawerLayout!!.addDrawerListener(mDrawerToggle!!)

        navigationView!!.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Click menu item", Toast.LENGTH_SHORT).show()
        drawerLayout!!.closeDrawer(Gravity.START)
        item.setChecked(true)
        val itemId : Int = item.itemId

        return true
    }
}

