package com.example.alcohol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.alcohol.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView
import android.text.BoringLayout



class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding : ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main_user)
            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)
            replaceFragment(Home())

            drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

            val toolbar = findViewById<Toolbar>(R.id.toolbar)

            setSupportActionBar(toolbar)

            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            navigationView.setNavigationItemSelectedListener(this)

            val toggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_nav,
                R.string.close_nav
            )
            drawerLayout.addDrawerListener(toggle)

            toggle.syncState()
            drawerLayout.addDrawerListener(toggle)

            toggle.syncState()

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeUserFragment()).commit()
                navigationView.setCheckedItem(R.id.nav_home)
            }





            binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.fit -> replaceFragment(Fit())
                R.id.profile -> replaceFragment(Profile())


                else ->{



                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeUserFragment()).commit()

            R.id.nav_settings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsUserFragment()).commit()

            R.id.nav_history -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HistoryUserFragment()).commit()

            R.id.nav_info -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, InformationUserFragment()).commit()

            R.id.nav_share -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareUserFragment()).commit()

            R.id.nav_logout -> Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return  true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

}
