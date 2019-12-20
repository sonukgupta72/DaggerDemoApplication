package com.sonukgupta72.daggerdemoapplication

import android.os.Bundle
import com.sonukgupta72.daggerdemoapplication.fragment.ShowListFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, ShowListFragment.newInstance()).commit()
    }
}
