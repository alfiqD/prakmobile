package com.example.alfiq_apps.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alfiq_apps.R
import com.example.alfiq_apps.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Konfigurasi Toolbar (Sudah di-comment title-nya karena pakai CollapsingToolbar)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
//            title = "Activity Fifth"
//            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnWebView.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // 1. Sembunyikan FAB saat aplikasi pertama dibuka
        binding.fabToTop.hide()

        // 2. Deteksi saat layar di-scroll
        binding.nestedScrollView.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            if (scrollY > 300) {
                binding.fabToTop.show()
            } else {
                binding.fabToTop.hide()
            }
        }

        // 3. Aksi saat tombol diklik (kembali ke atas)
        binding.fabToTop.setOnClickListener {
            binding.nestedScrollView.smoothScrollTo(0, 0)
        }

        // ========================================================
        // IMPROVISASI VECTOR ASSET: Mengubah Warna secara dinamis
        // ========================================================
        var isLiked = false

        binding.btnFavorite.setOnClickListener {
            isLiked = !isLiked

            if (isLiked) {
                // Jika diklik: Warnai Vector menjadi KUNING EMAS
                binding.btnFavorite.setColorFilter(android.graphics.Color.parseColor("#FFD700"))
            } else {
                // Jika batal: Kembalikan warna Vector menjadi ABU-ABU
                binding.btnFavorite.setColorFilter(android.graphics.Color.DKGRAY)
            }
        }
        // ========================================================

    } // <--- BATAS AKHIR onCreate


    // ====================================================================
    // MENGHUBUNGKAN FILE XML MENU (Pastikan nama file-nya main_menu.xml)
    // ====================================================================
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // ====================================================================
    // MENANGKAP KLIK DARI MENU & IMPROVISASI SUB-MENU
    // ====================================================================
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Tombol panah kembali di Toolbar
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            // Klik ikon kaca pembesar
            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            // IMPROVISASI: Menangkap klik anak/sub-menu dari Settings
            R.id.sub_dark_mode -> {
                Toast.makeText(this, "Tema Gelap Diaktifkan!", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.sub_light_mode -> {
                Toast.makeText(this, "Tema Terang Diaktifkan!", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}