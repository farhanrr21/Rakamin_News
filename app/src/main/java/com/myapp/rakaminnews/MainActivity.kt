package com.myapp.rakaminnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.myapp.rakaminnews.database.Artikel_Database
import com.myapp.rakaminnews.fragment.Bookmark
import com.myapp.rakaminnews.fragment.Home
import com.myapp.rakaminnews.fragment.Profile
import com.myapp.rakaminnews.repositori.News_Repository

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: News_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(Home())

        //Setup
        val newsRepository = News_Repository(Artikel_Database(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(News_ViewModel::class.java)

        //Flag
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)

        //Bottom navbar
        val navbar = findViewById<ChipNavigationBar>(R.id.bottom_navigation)
        navbar.setItemSelected(R.id.home, true)
        navbar.setOnItemSelectedListener {
            when(it){
                R.id.home ->{
                    replaceFragment(Home())
                }
                R.id.bookmark -> {
                    replaceFragment(Bookmark())
                }
                R.id.profile -> {
                    replaceFragment(Profile())
                }
            }
        }


        }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout,fragment)
        fragmentTransaction.commit()

    }


}