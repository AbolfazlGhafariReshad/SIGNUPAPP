package com.example.appsignup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [singup.newInstance] factory method to
 * create an instance of this fragment.
 */
class singup : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_singup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


        val checkbox = view.findViewById<CheckBox>(R.id.check)
        val btnsub = view.findViewById<Button>(R.id.btnsub)
        val txtemail = view.findViewById<EditText>(R.id.txtemail)
        val txtpass = view.findViewById<EditText>(R.id.txtpass)
        val txttpass = view.findViewById<EditText>(R.id.txttpass)
        val txtphone = view.findViewById<EditText>(R.id.txtphone)
        val txtaddress = view.findViewById<EditText>(R.id.txtaddress)

        val txt = view.findViewById<TextView>(R.id.txt)
        val txtchp = view.findViewById<TextView>(R.id.txtchp)


        if (checkbox.isChecked)
            txt.text = "1"

        btnsub.setOnClickListener {

            if (txtphone.text.toString().startsWith("09"))
                txtchp.text = "1"

            if (txtemail.text.toString().equals(""))
                Toast.makeText(requireContext(), "ایمیل خود را کامل وارد نمایید", Toast.LENGTH_SHORT).show()
            if (txtpass.text.toString().equals(""))
                Toast.makeText(requireContext(), "رمز عبور نمیتواند خالی بماند!", Toast.LENGTH_SHORT).show()
            if (txttpass.text.toString().equals(""))
                Toast.makeText(requireContext(), "رمز عبور خود را تکرار کنید", Toast.LENGTH_SHORT).show()
            if (txtphone.text.toString().equals(""))
                Toast.makeText(requireContext(), "شماره تلفن همراه خود را وارد کنید", Toast.LENGTH_SHORT).show()
            if (txtphone.text.toString() == "")
                Toast.makeText(requireContext(), "شماره تلفن همراه صحیح نیست!", Toast.LENGTH_SHORT).show()
            if (txtaddress.text.toString().equals(""))
                Toast.makeText(requireContext(), "آدرس (کد پستی) خود را وارد کنید", Toast.LENGTH_SHORT).show()
            if (txt.text == "1")
                Toast.makeText(requireContext(), "تیک قوانین و مقررات برای ثبت نام الزامیست", Toast.LENGTH_SHORT).show()


            if (txtphone.text.toString().startsWith("09")){



            }


        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment singup.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            singup().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}