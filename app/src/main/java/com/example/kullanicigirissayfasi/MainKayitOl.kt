package com.example.kullanicigirissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kullanicigirissayfasi.databinding.ActivityMainHosgeldinizBinding
import com.example.kullanicigirissayfasi.databinding.ActivityMainKayitOlBinding

private lateinit var binding:ActivityMainKayitOlBinding
class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnKaydet.setOnClickListener {

            var kullaniciBilgisi = binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola = binding.kayitParola.text.toString()

            var SharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            //veri ekleme
            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("parola","$kullaniciParola").apply()
            Toast.makeText(this,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()


        }


        binding.btnGiriseDon.setOnClickListener {
            val intent= Intent(this@MainKayitOl,MainActivity::class.java)
            startActivity(intent)
        }
    }
}