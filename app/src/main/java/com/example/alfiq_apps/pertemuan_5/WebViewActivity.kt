package com.example.alfiq_apps.pertemuan_5

import android.os.Bundle
import android.view.MenuItem // <--- TAMBAHAN IMPORT INI PENTING
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alfiq_apps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. PENGATURAN PADDING (Agar aman dari status bar)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2. MENGAKTIFKAN TOOLBAR
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 3. KONFIGURASI WEBVIEW
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://merdeka.com")

        // 4. ANIMASI HIDE/SHOW TOOLBAR SAAT SCROLL
        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                binding.appBar.setExpanded(false, true) // sembunyikan saat scroll turun
            } else if (scrollY < oldScrollY) {
                binding.appBar.setExpanded(true, true) // tampilkan saat scroll naik
            }
        }
    } // <--- PENUTUP onCreate HARUS DI SINI

    // ========================================================
    // 5. TAMBAHAN INI AGAR PANAH BACK DI TOOLBAR BERFUNGSI
    // ========================================================
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Menutup halaman WebView dan kembali ke halaman sebelumnya
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // 6. MENGAKTIFKAN TOMBOL BACK PADA HP UNTUK WEBVIEW
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack() // Kembali ke halaman sebelumnya di dalam web
        } else {
            super.onBackPressed() // Keluar dari activity jika mentok
        }
    }
}