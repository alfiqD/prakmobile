package com.example.alfiq_apps.Home.pertemuan_7

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.alfiq_apps.R
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

        // PERBAIKAN 1: Menampilkan fragment pertama TANPA addToBackStack
        if (savedInstanceState == null) {
            replaceFragment(SatuFragment(), false)
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

    // PERBAIKAN 2: Menambahkan parameter addToStack dengan default value 'true'
    private fun replaceFragment(fragment: Fragment, addToStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)

        // Hanya tambahkan ke BackStack jika addToStack bernilai true
        if (addToStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Jika masih ada tumpukan fragment, keluarkan dulu (pop)
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish() // Jika sudah di fragment pertama, tutup activity
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}