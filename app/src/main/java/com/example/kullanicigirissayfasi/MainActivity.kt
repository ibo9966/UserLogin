package com.example.kullanicigirissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kullanicigirissayfasi.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var preferences:SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)
        binding.btnGirisYap.setOnClickListener {

            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliParola = preferences.getString("parola","")

            var girisKullanici = binding.girisKullaniciAdi.text.toString()
            var girisParola= binding.girisParola.text.toString()

            if ((kayitliKullanici==girisKullanici) && (kayitliParola==girisParola)){
                val intent=Intent(this@MainActivity,MainHosgeldiniz::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Giriş Bilgileri Hatalı.",Toast.LENGTH_LONG).show()
            }

        }

        binding.btnKayitOl.setOnClickListener {
            val intent=Intent(this@MainActivity,MainKayitOl::class.java)
            startActivity(intent)
        }
    }
}