package com.example.sharedelementrnd.fragmentToActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.sharedelementrnd.R
import com.example.sharedelementrnd.activityToActivity.SmallActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentToActivityButton.setOnClickListener {
            linearLayout.visibility = View.GONE
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(
                R.id.container,
                ImageSmallFragment()
            )
            ft.addToBackStack("imageListFragment")
            ft.commit()

        }


        activityToActivityButton.setOnClickListener {
            val intent = Intent(this,SmallActivity()::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.popBackStack()
        linearLayout.visibility = View.VISIBLE

    }

}