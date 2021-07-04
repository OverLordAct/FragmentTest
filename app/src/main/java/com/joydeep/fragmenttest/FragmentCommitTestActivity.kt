package com.joydeep.fragmenttest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.joydeep.fragmenttest.databinding.ActivityFragmentCommitTestBinding

class FragmentCommitTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentCommitTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG", "Activity onCreate")
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentCommitTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val fragment = FragmentA.newInstance("Fragment A")
                add(binding.container1.id, fragment, "A")
                setReorderingAllowed(true)
            }

            supportFragmentManager.commit {
                val fragment = FragmentB.newInstance("Fragment B")
                add(binding.container2.id, fragment)
                setReorderingAllowed(true)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Activity onPause")
        supportFragmentManager.commit {
            val fragment = supportFragmentManager.findFragmentById(binding.container1.id)
            if (fragment != null) {
                remove(fragment)
            }
        }
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
        Log.d("TAG", "====================")
        super.onResume()
    }

    override fun onStop() {
        Log.d("TAG", "Activity onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("TAG", "Activity onDestroy")
        Log.d("TAG", "====================")
        supportFragmentManager.commit(true) {
            val fragment = supportFragmentManager.findFragmentById(binding.container2.id)
            if (fragment != null) {
                remove(fragment)
            }
            setReorderingAllowed(true)
        }
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