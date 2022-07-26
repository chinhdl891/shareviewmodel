package com.example.roomlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.roomlivedata.databinding.ActivityMainBinding
import com.example.roomlivedata.fragment.AddUserFragment
import com.example.roomlivedata.fragment.ListUserFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val addUserFragment = AddUserFragment()
        supportFragmentManager.beginTransaction().add(R.id.fml_main_add, addUserFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.fml_main_list, ListUserFragment())
            .commit()
//        mBinding.btnMainAdd.setOnClickListener{
//            supportFragmentManager.beginTransaction().replace(R.id.fml_main_add, ListUserFragment())
//                .commit()
//        }
        setContentView(mBinding.root)
    }
}