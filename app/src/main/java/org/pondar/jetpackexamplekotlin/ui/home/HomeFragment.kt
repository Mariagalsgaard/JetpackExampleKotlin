package org.pondar.jetpackexamplekotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import org.pondar.jetpackexamplekotlin.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.data.observe(viewLifecycleOwner, {
            //"it" is the same as homeViewModel.data.value
            textView.text = it
            Log.d("observer","new value observed: $it")
        })
        homeViewModel.downloadFromServer()

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        aboutButton.setOnClickListener{
            //val data = "Hej fra HomeFragment"
            val action = HomeFragmentDirections.aboutAction("Hej fra HomeFragment")
            findNavController().navigate(action)
        }
    }

}




