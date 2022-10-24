package com.kismiwati.application

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kismiwati.application.databinding.ActivityUtamaBinding

class UtamaActivity : AppCompatActivity() {
    var idPengguna = ""

    //componion object untuk medeklarasikan objek kelas web_prefix dan web
    companion object {

        const val WEB_PREFIX = "https://www.briliofood.net/resep/15-resep-masakan-ala-restoran-mewah-enak-dan-mudah-dibuat-200616q.html"
        const val Web = "https://www.briliofood.net/resep/15-resep-minuman-ala-kafe-enak-dan-gampang-dibuat-sendiri-200304j.html"
    }

    //onCreate digunakan untuk menginisialisasikan Activity pada kondisi awal
    //saveInstanceState merupakan objek bundle yang berisi status yang sebelumnya disimpan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //method setOnClickListener digunakan user untuk selalu mendengarkan klik dari user pada objek button. dan akan menampilkan jika Button di-klik
        binding.ubtnMak.setOnClickListener { tmlMak() }
        binding.ubtnMin.setOnClickListener { tmlMin() }
        binding.ubtnResMak.setOnClickListener { tmlResMak() }
        binding.ubtnResMin.setOnClickListener { tmlResMin() }
    }

    private fun tmlMak() {
        val intentMak = Intent(this, MakananActivity::class.java)
        // startActivity digunakan untuk mengaktifkan intentMak
        startActivity(intentMak)
    }

    private fun tmlMin() {
        val intentMin = Intent(this, MinumanActivity::class.java)
        // startActivity digunakan untuk mengaktifkan intentMin
        startActivity(intentMin)
    }
    private fun tmlResMak() {
        // menggunakan intent implisit yang digunakan untuk menjembatani atau menghubungkan interaksi antar Activitimain dan masuk activity
        // dengan variabel queryUrl, data didalamnya web_prefix + idPengguna
        val queryUrl: Uri = Uri.parse(WEB_PREFIX)
        // digunakan untuk menyiapkan variabel intent dengan menggunakan parameter
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // startActivity digunakan untuk mengaktifkan intent
        startActivity(intent)
    }
    private fun tmlResMin() {
        // menggunakan intent implisit yang digunakan untuk menjembatani atau menghubungkan interaksi antar Activitimain dan masuk activity
        // dengan variabel queryUrl, data didalamnya web_prefix + idPengguna
        val queryUrl: Uri = Uri.parse(Web)
        // digunakan untuk menyiapkan variabel intent dengan menggunakan parameter
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // startActivity digunakan untuk mengaktifkan intent
        startActivity(intent)
    }
}