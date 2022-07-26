package com.example.roomlivedata.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomlivedata.R
import com.example.roomlivedata.adapter.UserAdapter
import com.example.roomlivedata.viewmodel.UserViewModel
import com.example.roomlivedata.databinding.FragmentListUserBinding


class ListUserFragment : Fragment() {
    lateinit var viewModel: UserViewModel
    private lateinit var viewBinding: FragmentListUserBinding
    var userAdapter: UserAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        activity?.let { act ->
            viewModel = ViewModelProvider(act)[UserViewModel::class.java]
        }

        viewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_list_user, container, false)
        userAdapter = UserAdapter()
        viewModel.getListUser()
        viewBinding.rcvListUser.layoutManager = LinearLayoutManager(activity)
        viewBinding.rcvListUser.adapter = userAdapter
        observer()
        return viewBinding.root
    }

    private fun observer() {
        viewModel.listUser.observe(viewLifecycleOwner) {
            userAdapter?.initData(it)
        }
        viewModel.content.observe(viewLifecycleOwner) {
            viewBinding.tvListSize.text = it
        }
    }
}
