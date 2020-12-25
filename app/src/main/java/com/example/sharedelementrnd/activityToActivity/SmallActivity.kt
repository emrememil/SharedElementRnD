package com.example.sharedelementrnd.activityToActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharedelementrnd.R
import com.example.sharedelementrnd.adapter.SmallImageItemClickListener
import com.example.sharedelementrnd.adapter.SmallImageListAdapter
import com.example.sharedelementrnd.fragmentToActivity.SmallImageDetailActivity
import kotlinx.android.synthetic.main.activity_small.*
import kotlinx.android.synthetic.main.fragment_image_small.*

class SmallActivity : AppCompatActivity(), SmallImageItemClickListener {

    lateinit var mAdapter: SmallImageListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small)

        mAdapter = SmallImageListAdapter(this, this)
        activitySmallRecylerView.layoutManager = LinearLayoutManager(this)
        activitySmallRecylerView.adapter = mAdapter

        mAdapter.setItems(fillActionList())
    }

    private fun fillActionList(): ArrayList<Int> {
        return arrayListOf(
            R.drawable.nature0,
            R.drawable.nature1,
            R.drawable.nature2,
            R.drawable.nature3,
            R.drawable.nature4,
            R.drawable.nature5,
            R.drawable.nature6,
            R.drawable.nature8
        )
    }

    override fun onItemClick(item: Int, imageView: ImageView) {
        val detailIntent = Intent(this, DetailActivity::class.java)
        val imageViewPair =
            androidx.core.util.Pair.create<View, String>(imageView, "image_transition_name")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageViewPair)
        detailIntent.putExtra("picture", item)
        startActivity(detailIntent, options.toBundle())
    }
}