package com.example.sharedelementrnd.fragmentToActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.view.MenuItem
import com.example.sharedelementrnd.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_small_image_detail.*

class SmallImageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_image_detail)
        val item = intent.extras?.get("picture") as Int

        Picasso.get().load(item).resize(512,512).noFade().into(ivDetail)


        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition?) {
                Picasso.get().load(item).resize(512,512).noFade().noPlaceholder().into(ivDetail)
                transition?.removeListener(this)
            }

            override fun onTransitionResume(transition: Transition?) {
            }

            override fun onTransitionPause(transition: Transition?) {
            }

            override fun onTransitionCancel(transition: Transition?) {
            }

            override fun onTransitionStart(transition: Transition?) {
            }
        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) {
            //to reverse the scene transition animation
            supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }

}