package com.example.kullanicigirissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kullanicigirissayfasi.databinding.ActivityMainBinding
import com.example.kullanicigirissayfasi.databinding.ActivityMainHosgeldinizBinding

private lateinit var binding: ActivityMainHosgeldinizBinding
private lateinit var preferences:SharedPreferences
class MainHosgeldiniz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //xml'den verilerimizi çekiyoruz
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliKullanici= preferences.getString("kullanici","")
        var kayitliParola= preferences.getString("parola","")

        //textView'lere kayıtlı bilgileri aktarıyoruz.
        binding.kullaniciBilgisi.text = "Kullanıcı Adı : ${kayitliKullanici.toString()}"
        binding.kullaniciParola.text = "Parola : ${kayitliParola.toString()}"

        binding.btnCikisYap.setOnClickListener {
            val intent=Intent(this@MainHosgeldiniz,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}