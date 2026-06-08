package com.example.alfiq_apps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.lifecycleScope
import com.example.alfiq_apps.AuthActivity
import com.example.alfiq_apps.Home.pertemuan_10.TenthActivity
import com.example.alfiq_apps.Home.pertemuan_13.ThirteenthActivity
import com.example.alfiq_apps.Home.pertemuan_2.SecondActivity
import com.example.alfiq_apps.Home.pertemuan_3.ThirdActivity
import com.example.alfiq_apps.Home.pertemuan_4.FourthActivity
import com.example.alfiq_apps.Home.pertemuan_5.FifthActivity
import com.example.alfiq_apps.Home.pertemuan_7.SeventhActivity
import com.example.alfiq_apps.Home.pertemuan_9.NinthActivity
import com.example.alfiq_apps.R
import com.example.alfiq_apps.data.api.CatFactApiClient
import com.example.alfiq_apps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** Ganti menjadi versi binding */
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"

        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin Keluar?")
                .setPositiveButton("Ya") { dialog, _ ->

                    sharedPref.edit {
                        clear()
                    }
                    dialog.dismiss()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }

                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
        binding.btnToSecond.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }
        binding.btnToThird.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.btnToFourth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToFifth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSeventh.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }
        binding.btnToNinth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToTenth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToThirteenth.setOnClickListener {
            // Berpindah dari FifthActivity ke WebViewActivity
            val intent = Intent(requireContext(), ThirteenthActivity::class.java)
            startActivity(intent)
        }

            binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }


    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

}




