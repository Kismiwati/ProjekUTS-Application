package com.kismiwati.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.kismiwati.application.adapter.ItemAdapter
import com.kismiwati.application.data.Datasource

class MakananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)

        //digunakan untuk menginisialisasi data
        val myDataset = Datasource().loadResto()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)
    }
}