package com.android.products.fragment

import android.app.Activity.RESULT_OK
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.products.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        var name = activity!!.getSharedPreferences("Accounts", MODE_PRIVATE).getString("name", "")
        editText_profile_name.setText(name)
        button_save.setOnClickListener { l: View? ->
            //
            activity!!.getSharedPreferences("Accounts", MODE_PRIVATE).edit().putString("name", editText_profile_name.text.toString()).apply()
            activity!!.setResult(RESULT_OK)
            activity!!.finish()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    //
                }
            }
    }
}