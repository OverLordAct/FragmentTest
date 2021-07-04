package com.joydeep.fragmenttest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.joydeep.fragmenttest.databinding.FragmentMainBinding

class FragmentA : Fragment {

    companion object {
        private const val EXTRA_FRAGMENT_NAME = "EXTRA_FRAGMENT_NAME"
        fun newInstance(fragmentName: String): FragmentA {
            return FragmentA().apply {
                arguments = Bundle().also {
                    it.putString(EXTRA_FRAGMENT_NAME, fragmentName)
                }
            }
        }
    }

    constructor() : super() {
        Log.d("TAG", "Fragment constructor FragmentA is called")
    }

    private var binding: FragmentMainBinding? = null
    private val instance = arguments?.getString(EXTRA_FRAGMENT_NAME)
    private lateinit var viewModel: FragmentViewModel

    override fun onAttach(context: Context) {
        Log.d("TAG", "Fragment FragmentA onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG", "Fragment FragmentA onCreate")
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(FragmentViewModel::class.java)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("TAG", "Fragment FragmentA onSaveInstanceState")
        outState.putString("Y", "XYZ")
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.d("TAG", "Fragment FragmentA onViewStateRestored")
        super.onViewStateRestored(savedInstanceState)
        Log.d(
            "TAG",
            "Fragment FragmentA onViewStateRestored ${savedInstanceState?.getString("Y")}"
        )
    }

    override fun onStart() {
        Log.d("TAG", "Fragment FragmentA onStart")
        super.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TAG", "Fragment FragmentA onCreateView")
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("TAG", "Fragment FragmentA onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        binding?.textview?.text = arguments?.getString(EXTRA_FRAGMENT_NAME)
        binding?.textview?.setOnClickListener {
            viewModel.showToast()
        }

        binding?.setText?.setOnClickListener {
            binding?.textview?.text = binding?.textinput?.text
        }
    }

    override fun onResume() {
        Log.d("TAG", "Fragment FragmentA onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("TAG", "Fragment FragmentA onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("TAG", "Fragment FragmentA onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("TAG", "Fragment FragmentA onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("TAG", "Fragment FragmentA onDestroy")
        super.onDestroy()
        binding = null
    }

    override fun onDetach() {
        Log.d("TAG", "Fragment FragmentA onDetach")
        super.onDetach()
    }
}