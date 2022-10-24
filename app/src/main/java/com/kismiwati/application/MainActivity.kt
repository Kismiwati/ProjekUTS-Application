package com.kismiwati.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kismiwati.application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Method binding dibawah ini digunakan untuk menampilkan layout activity_main
        //layout inflate digunakan untuk menghubungkan main_activity dengan sub activity yaitu bagian kecil dari activity
        //inflate digunakan untuk memanggil widget pada activity_main
        binding.abtnPelanggan.setOnClickListener { tmlPel() }
        //method setOnClickListener digunakan user untuk selalu mendengarkan klik dari user pada objek button. dan akan menampilkan jika Button di-klik
        binding.abtnLogin.setOnClickListener { tmlLog() }
        binding.btnTbh.setOnClickListener { tmlTam() }
    }
    private fun tmlPel() {
        //pada bagian ini digunakan untuk mengarahkan tombol pelanggan saat di klik akan beralih ke halaman UtamaActivity
        val intentPel = Intent(this, UtamaActivity::class.java)
        startActivity(intentPel)
    }
    private fun tmlLog() {
        //pada bagian ini digunakan untuk mengarahkan tombol login agar saat di klik akan mengarah ke halaman MasukActivity
        val intentLog = Intent(this, MasukActivity::class.java)
        startActivity(intentLog)
    }

    private fun tmlTam() {
        //pada bagian ini digunakan untuk mengarahkan tombol login agar saat di klik akan mengarah ke halaman MasukActivity
        val intentLog = Intent(this, DaftarActivity::class.java)
        startActivity(intentLog)
    }
}