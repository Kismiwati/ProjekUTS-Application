package com.kismiwati.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kismiwati.application.databinding.ActivityMasukBinding

class MasukActivity : AppCompatActivity() {
    //onCreate digunakan untuk menginisialisasikan Activity pada kondisi awal
    //saveInstanceState merupakan objek bundle yang berisi status yang sebelumnya disimpan
    lateinit var binding: ActivityMasukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mbtnLogin.setOnClickListener { mcekLog() }
    }
    private fun mcekLog() {
        // method toString digunakan untuk merubah nilai type data menjadi type data string.
        val mUsername = binding.mUsernameText.text.toString()
        val mPassword = binding.mPasswordText.text.toString()

        //method isEmpty digunakan untuk mengecek kondisi pada variabel type string
        //if else digunakan untuk memerikasa atau mengecek kondisi yang diisikan apakah sudah sesuai atau belum. jika sudah benar maka akan menampilkan toast.

        if (mUsername.isEmpty() || mPassword.isEmpty()) {
            Toast.makeText(this, "Mohon masukkan username dan password", Toast.LENGTH_SHORT).show()
            return
        }
        if (mUsername == "kismiwati" && mPassword == "123456") {
            val intent = Intent(this, UtamaActivity::class.java)

            //startActivity digunakan untuk menjalankan activity melalui intent
            intent.putExtra("Username", binding.mUsernameText.text.toString())
            startActivity(intent)
            //else digunakan untuk memberikan komentar jika Nama pengguna dan password yang dimasukkan salah
        }else{
            Toast.makeText(this, "Username & Password yang dimasukkan salah.", Toast.LENGTH_SHORT).show()
            return
        }
    }
}