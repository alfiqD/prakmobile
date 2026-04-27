package com.example.alfiq_apps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alfiq_apps.databinding.ActivityMainBinding
import com.example.alfiq_apps.Home.pertemuan_4.FourthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import androidx.core.content.edit
import com.example.alfiq_apps.Home.pertemuan_2.SecondActivity
import com.example.alfiq_apps.Home.pertemuan_3.ThirdActivity
import com.example.alfiq_apps.Home.pertemuan_5.FifthActivity
import com.example.alfiq_apps.Home.pertemuan_7.SeventhActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)

            /*tambahkan bagian berikut*/
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("umur", 25)

            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin Keluar?")
                .setPositiveButton("Ya") { dialog, _ ->

                    sharedPref.edit {
                        clear()
                    }
                    dialog.dismiss()

                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
        binding.btnToSecond.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        binding.btnToThird.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.btnToFourth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToFifth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSeventh.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
    }
}
