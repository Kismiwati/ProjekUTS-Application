package com.kismiwati.application.data

import com.kismiwati.application.R
import com.kismiwati.application.model.Resto

class Datasource {
    fun loadResto(): List<Resto> {
        //pada bagian ini digunakan untuk menampilkan teks dan gambar yang akan ditampilkan di halaman daftar makanan
        return listOf<Resto>(
            Resto(R.string.makanan1, R.drawable.cardview_1),
            Resto(R.string.makanan2, R.drawable.cardview_2),
            Resto(R.string.makanan3, R.drawable.cardview_3),
            Resto(R.string.makanan4, R.drawable.cardview_4),
            Resto(R.string.makanan5, R.drawable.cardview_5),
            Resto(R.string.makanan6, R.drawable.cardview_6)
        )
    }
    //pada bagian ini digunakan untuk menampilkan teks dan gambar pada halamamn daftar minum
    fun loadMinum(): List<Resto> {
        return listOf<Resto> (
            Resto(R.string.minuman1, R.drawable.cardview_7),
            Resto(R.string.minuman2, R.drawable.cardview_8),
            Resto(R.string.minuman3, R.drawable.cardview_9),
            Resto(R.string.minuman4, R.drawable.cardview_10),
            Resto(R.string.minuman5, R.drawable.cardview_11),
            Resto(R.string.minuman6, R.drawable.cardview_12),
        )
    }
}