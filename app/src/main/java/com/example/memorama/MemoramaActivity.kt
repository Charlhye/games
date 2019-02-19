package com.example.memorama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama.*

class MemoramaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)
        val recyclerView = recyclerView1
        recyclerView.setHasFixedSize(true)
        var gridLayoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = gridLayoutManager
        val chips = ArrayList<Chip>()
        for (i in 1..12)
            chips.add(Chip(R.mipmap.ic_launcher))
        var adapter = MemoramaAdapter(chips)
        recyclerView.adapter = adapter
    }
}
