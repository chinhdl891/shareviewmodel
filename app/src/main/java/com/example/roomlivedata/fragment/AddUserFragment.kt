package com.example.roomlivedata.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.roomlivedata.R
import com.example.roomlivedata.model.User
import com.example.roomlivedata.database.UserDataBase
import com.example.roomlivedata.viewmodel.UserViewModel
import com.example.roomlivedata.databinding.FragmentAddUserBinding

class AddUserFragment : Fragment() {
    lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        activity?.let {
            viewModel =
                ViewModelProvider(it)[UserViewModel::class.java]

        }

        val mBinding: FragmentAddUserBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_user, container, false)

        mBinding.btnAdd.setOnClickListener {
            val name = mBinding.edtAddName.text.toString()
            val old = mBinding.edtAddOld.text.toString()
            context?.let { context ->
                UserDataBase.getDatabase(context).userDAO().onInsert(User(name = name, old = old))
            }
            viewModel.setContent(name)
        }
        return mBinding.root
    }
}

