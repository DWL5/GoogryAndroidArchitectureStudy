package com.world.tree.architecturestudy.view

import android.content.Intent

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.world.tree.architecturestudy.CommonApplication
import com.world.tree.architecturestudy.MovieContainer
import com.world.tree.architecturestudy.R
import com.world.tree.architecturestudy.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MovieAdapter.OnItemClickListener {
    private lateinit var movieContainer: MovieContainer
    private lateinit var adapter: MovieAdapter
    private lateinit var binding:ActivityMainBinding

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        movieContainer = (application as CommonApplication).movieContainer
        adapter = MovieAdapter()
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter


        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.toastMsg.observe(this, Observer {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun goToLink(link: String) {
        Log.d("Main", "goToLink() called link : $link")
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link))
        )
    }
}
