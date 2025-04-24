package com.example.taskly.ui.create

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taskly.R
import com.example.taskly.TaskViewModel
import com.example.taskly.data.model.Task
import com.example.taskly.databinding.FragmentCreateBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding
    private val viewModel: TaskViewModel by viewModels()
    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengatur tanggal saat mengetuk EditText untuk tanggal
        binding.etDate.setOnClickListener {
            showDatePickerDialog()
        }

        // Mengatur waktu saat mengetuk EditText untuk waktu
        binding.etTime.setOnClickListener {
            showTimePickerDialog()
        }

        // Menyimpan tugas baru
        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val deadlineMillis = calendar.timeInMillis

            if (title.isNotEmpty()) {
                viewModel.insert(Task(title = title, deadline = deadlineMillis))
                findNavController().navigateUp()
            } else {
                binding.etTitle.error = "Judul tidak boleh kosong"
            }
        }
    }

    // Fungsi untuk menampilkan DatePickerDialog
    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, y, m, d ->
            calendar.set(Calendar.YEAR, y)
            calendar.set(Calendar.MONTH, m)
            calendar.set(Calendar.DAY_OF_MONTH, d)

            val dateFormatted = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time)
            binding.etDate.setText(dateFormatted)
        }, year, month, day)

        datePickerDialog.show()
    }

    // Fungsi untuk menampilkan TimePickerDialog
    private fun showTimePickerDialog() {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(requireContext(), { _, h, m ->
            calendar.set(Calendar.HOUR_OF_DAY, h)
            calendar.set(Calendar.MINUTE, m)

            val timeFormatted = String.format("%02d:%02d", h, m)
            binding.etTime.setText(timeFormatted)
        }, hour, minute, true)

        timePickerDialog.show()
    }
}