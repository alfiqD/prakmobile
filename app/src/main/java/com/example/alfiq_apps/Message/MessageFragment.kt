package com.example.alfiq_apps.Message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.alfiq_apps.Message.tutorial.TutorialMessageActivity
import com.example.alfiq_apps.R
import com.example.alfiq_apps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", R.drawable.images),
        MessageModel("Budi", "Sudah makan?", R.drawable.images),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", R.drawable.images),
        MessageModel("Dika", "Besok kita rapat jam 9", R.drawable.images),
        MessageModel("Eka", "Nice job kemarin!", R.drawable.images),
        MessageModel("Fajar", "Lagi ngapain?", R.drawable.images),
        MessageModel("Gita", "Boleh minta tolong?", R.drawable.images),
        MessageModel("Hana", "Lihat email ya", R.drawable.images),
        MessageModel("Irfan", "Oke noted", R.drawable.images),
        MessageModel("Joko", "Sampai jumpa besok", R.drawable.images)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"


        }
        setHasOptionsMenu(true)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
