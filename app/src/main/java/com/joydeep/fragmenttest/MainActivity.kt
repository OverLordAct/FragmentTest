package com.joydeep.fragmenttest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.joydeep.fragmenttest.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity {

    companion object {
        var count = 0
        var count2 = 1
    }

    private lateinit var binding: ActivityMainBinding
    private var currFragment: Fragment? = null
    private lateinit var viewModel: ActivityViewModel

    constructor() : super() {
        Log.d("TAG", "Activity constructor called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG", "Activity onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        val x = defaultViewModelProviderFactory

        binding.button1.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
//                count++
                val fragment = MainFragment.newInstance("Fragment ${count}")
//                attach(fragment)
                add(binding.fragmentContainer.id, fragment)
                addToBackStack(null)
                currFragment = fragment
            }
        }

        binding.button2.setOnClickListener {
//            val fragment = supportFragmentManager.fragments.first()
            supportFragmentManager.commit {
                currFragment?.let { it1 -> detach(it1) }
            }
        }

        binding.button3.setOnClickListener {
//            supportFragmentManager.commit {
//                currFragment?.let { it1 -> attach(it1) }
//            }
            viewModel.showToast()
        }

        supportFragmentManager.addFragmentOnAttachListener { fragmentManager, fragment ->
            Log.d(
                "TAG",
                "=========="
            )
            Log.d(
                "TAG",
                "Fragment ${count2++} has been attached to the fragment manager"
            )
            Log.d(
                "TAG",
                "=========="
            )
        }

        supportFragmentManager.addOnBackStackChangedListener {
            Log.d(
                "TAG",
                "=========="
            )
            Log.d("TAG", "Something has been added to the backstack")
            Log.d(
                "TAG",
                "=========="
            )
        }

        val intent = Intent()
    }

    override fun onRestart() {
        Log.d("TAG", "Activity onRestart")
        super.onRestart()
    }

    override fun onStart() {
        Log.d("TAG", "Activity onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("TAG", "Activity onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("TAG", "Activity onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("TAG", "Activity onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("TAG", "Activity onDestroy")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("TAG", "Activity onSaveInstanceState")
        outState.putString("X", "ABC")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("TAG", "Activity onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        val string = savedInstanceState.getString("X")
        Log.d("TAG", "Activity onRestoreInstanceState $string")
    }
}