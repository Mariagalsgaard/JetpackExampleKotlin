package org.pondar.jetpackexamplekotlin.ui.about

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.about_fragment.*
import org.pondar.jetpackexamplekotlin.R
import org.pondar.jetpackexamplekotlin.ui.loggedin.LoggedInFragmentArgs
import org.pondar.jetpackexamplekotlin.ui.loggedin.LoggedInViewModel

class AboutFragment : Fragment() {

    companion object {
        fun newInstance() = AboutFragment()
    }

    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    val args: AboutFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(AboutViewModel::class.java)
        // TODO: Use the ViewModel
        Log.d("AboutFragment", "about = ${args.aboutArgument}")
        nav_about.text = args.aboutArgument
    }
}


