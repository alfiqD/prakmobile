package com.example.alfiq_apps.pertemuan_7

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.alfiq_apps.R
import com.example.alfiq_apps.databinding.ActivityAuth2Binding
import com.example.alfiq_apps.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeventhBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menampilkan fragment pertama secara default jika ini pertama kali activity dibuat
        if (savedInstanceState == null) {
            replaceFragment(SatuFragment())
        }

            // Setup event click untuk mengganti fragment
            binding.btnFragment1.setOnClickListener {
                replaceFragment(SatuFragment())
            }

            binding.btnFragment2.setOnClickListener {
                replaceFragment(DuaFragment())
            }

            binding.btnFragment3.setOnClickListener {
                replaceFragment(TigaFragment())
            }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Seventh Activity"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Menutup halaman WebView dan kembali ke halaman sebelumnya
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}