package com.example.roomlivedata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlivedata.BR
import com.example.roomlivedata.R
import com.example.roomlivedata.database.UserDataBase
import com.example.roomlivedata.databinding.ItemUserBinding
import com.example.roomlivedata.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var listUser: List<User>? = null
    lateinit var context: Context
    fun initData(list: List<User>) {
        val diffUtil = listUser?.let { MyDiffUtil(it, list) }
        val diffResult = diffUtil?.let { DiffUtil.calculateDiff(it) }
        listUser = list as MutableList<User>
        diffResult?.dispatchUpdatesTo(this)
    }

    inner class UserViewHolder(var mBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun init(user: User) {
            mBinding.setVariable(BR.user, user)
            mBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: ItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false)
        context = parent.context
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.init(listUser?.get(position) ?: User())
        holder.itemView.setOnClickListener {
            try {
                UserDataBase.getDatabase(context).userDAO()
                    .onDelete(listUser?.get(holder.layoutPosition) ?: User())
            } catch (e: Exception) {

            }
        }
    }

    override fun getItemCount(): Int {
        return listUser?.size ?: 0
    }
}