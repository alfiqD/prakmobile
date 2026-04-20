package com.example.alfiq_apps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alfiq_apps.databinding.ActivityAuth2Binding
import com.example.alfiq_apps.pertemuan_3.ThirdResultActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import androidx.core.content.edit

class AuthActivity : AppCompatActivity() {

    // Gunakan binding yang sesuai dengan nama file XML Anda (ActivityAuth2Binding)
    private lateinit var binding: ActivityAuth2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate layout
        binding = ActivityAuth2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Gunakan binding.root untuk menangani window insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)


        binding.btnLogin.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (username == password && username.isNotEmpty()) {

                sharedPref.edit {
                    putBoolean("isLogin", true)
                    putString("username", username)
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Opsional: Tutup AuthActivity agar tidak bisa kembali dengan tombol back
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Oopsss")
                    .setMessage("Username atau Password salah/kosong!")
                    .setPositiveButton("Close") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}