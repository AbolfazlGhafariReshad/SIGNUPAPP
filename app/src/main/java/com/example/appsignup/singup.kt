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
        var txt = view.findViewById<TextView>(R.id.txt)

        val bundle: Bundle = Bundle()

        var sum1 = 1
        var sum2 = 2



        btnsub.setOnClickListener {

            var a: Boolean
            var b: Boolean
            var e: Boolean
            var g: Boolean

            a = false
            b = false
            e = false
            g = false

                if (txtemail.text.toString().equals("") || txtpass.text.toString().equals("") || txttpass.text.toString().equals("") || txtphone.text.toString().equals("") || txtaddress.text.toString().equals("")) {
                    Toast.makeText(requireContext(), "اطلاعات را به صورت کامل وارد کنید", Toast.LENGTH_SHORT).show()
                    b = true

                }

                if (!txtpass.getText().toString().equals(txttpass.getText().toString())) {
                    Toast.makeText(requireContext(), "رمز عبور را تایید کنید", Toast.LENGTH_SHORT).show()
                    e = true

                }

                if (txtphone.text.toString().startsWith("09")) {
                    g = true
                }

                if (g != true) {
                    Toast.makeText(requireContext(), "شماره را به صورت صحیح وارد کنید", Toast.LENGTH_LONG).show()
                }

                if (checkbox.isChecked) {
                    a = true
                }

                if (a != true) {
                    Toast.makeText(requireContext(), "قبول قوانین و مقررات الزامیست!", Toast.LENGTH_LONG).show()
                }

            txt.text = a.toString() + g.toString() + b.toString() + e.toString()

                if (txt.text.toString() == "truetruefalsefalse") {
                    bundle.putString("info", txtemail.text.toString())
                    bundle.putString("info2", txtpass.text.toString())
                    bundle.putString("info3", txtphone.text.toString())
                    bundle.putString("info4", txtaddress.text.toString())
                    Toast.makeText(requireContext(), "خوش امدید", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.action_singup_to_showinfo, bundle)
                }



        //
//            b != true && a == true && g == true && e != true

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