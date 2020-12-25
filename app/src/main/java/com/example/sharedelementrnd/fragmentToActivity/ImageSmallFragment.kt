package com.example.sharedelementrnd.fragmentToActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharedelementrnd.R
import com.example.sharedelementrnd.adapter.SmallImageItemClickListener
import com.example.sharedelementrnd.adapter.SmallImageListAdapter
import kotlinx.android.synthetic.main.fragment_image_small.*


class ImageSmallFragment : Fragment(), SmallImageItemClickListener {

    lateinit var mAdapter: SmallImageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_small, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mAdapter = SmallImageListAdapter(requireContext(), this)
        imageListRecylerView.layoutManager = LinearLayoutManager(requireContext())
        imageListRecylerView.adapter = mAdapter

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
        val detailIntent = Intent(requireContext(), SmallImageDetailActivity::class.java)
        val imageViewPair =
            androidx.core.util.Pair.create<View, String>(imageView, "image_transition_name")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), imageViewPair)
        detailIntent.putExtra("picture", item)
        startActivity(detailIntent, options.toBundle())
    }
}