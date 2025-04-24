package com.example.taskly.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskly.R
import com.example.taskly.TaskAdapter
import com.example.taskly.TaskViewModel
import com.example.taskly.databinding.FragmentListBinding

@Suppress("DEPRECATION")
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshTasks()
        }

        // Inisialisasi adapter
        adapter = TaskAdapter(
            onCheckChanged = { task -> viewModel.update(task) },
            onDelete = { task -> viewModel.delete(task) }
        )

        // Set RecyclerView dengan adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observe perubahan data dari ViewModel
        viewModel.allTasks.observe(viewLifecycleOwner) { tasks ->
            adapter.submitList(tasks)
            binding.swipeRefreshLayout.isRefreshing = false // selesai refresh
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_createFragment)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_deadline -> {
                viewModel.sortByDeadline()
                true
            }
            R.id.sort_status -> {
                viewModel.sortByStatus()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}