package com.cursokotlin.s8_quezada.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.cursokotlin.s8_quezada.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CategoryFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardTitle = view.findViewById<TextView>(R.id.cardTitle)
        val cardContent = view.findViewById<LinearLayout>(R.id.cardContent)

        cardTitle.setOnClickListener {
            if (cardContent.visibility == View.GONE) {
                cardContent.visibility = View.VISIBLE
                cardContent.alpha = 0f
                cardContent.animate().alpha(1f).setDuration(300).start()
            } else {
                cardContent.animate().alpha(0f).setDuration(200).withEndAction {
                    cardContent.visibility = View.GONE
                }.start()
            }
        }

        val cardTitle2 = view.findViewById<TextView>(R.id.cardTitle2)
        val cardContent2 = view.findViewById<LinearLayout>(R.id.cardContent2)
        cardTitle2.setOnClickListener {
            if (cardContent2.visibility == View.GONE) {
                cardContent2.visibility = View.VISIBLE
                cardContent2.alpha = 0f
                cardContent2.animate().alpha(1f).setDuration(300).start()
            } else {
                cardContent2.animate().alpha(0f).setDuration(200).withEndAction {
                    cardContent2.visibility = View.GONE
                }.start()
            }
        }

        val cardTitle3 = view.findViewById<TextView>(R.id.cardTitle3)
        val cardContent3 = view.findViewById<LinearLayout>(R.id.cardContent3)
        cardTitle3.setOnClickListener {
            if (cardContent3.visibility == View.GONE) {
                cardContent3.visibility = View.VISIBLE
                cardContent3.alpha = 0f
                cardContent3.animate().alpha(1f).setDuration(300).start()
            } else {
                cardContent3.animate().alpha(0f).setDuration(200).withEndAction {
                    cardContent3.visibility = View.GONE
                }.start()
            }
        }

        val cardTitle4 = view.findViewById<TextView>(R.id.cardTitle4)
        val cardContent4 = view.findViewById<LinearLayout>(R.id.cardContent4)
        cardTitle4.setOnClickListener {
            if (cardContent4.visibility == View.GONE) {
                cardContent4.visibility = View.VISIBLE
                cardContent4.alpha = 0f
                cardContent4.animate().alpha(1f).setDuration(300).start()
            } else {
                cardContent4.animate().alpha(0f).setDuration(200).withEndAction {
                    cardContent4.visibility = View.GONE
                }.start()
            }
        }

        val cardTitle5 = view.findViewById<TextView>(R.id.cardTitle5)
        val cardContent5 = view.findViewById<LinearLayout>(R.id.cardContent5)
        cardTitle5.setOnClickListener {
            if (cardContent5.visibility == View.GONE) {
                cardContent5.visibility = View.VISIBLE
                cardContent5.alpha = 0f
                cardContent5.animate().alpha(1f).setDuration(300).start()
            } else {
                cardContent5.animate().alpha(0f).setDuration(200).withEndAction {
                    cardContent5.visibility = View.GONE
                }.start()
            }
        }

        val cardTitle6 = view.findViewById<TextView>(R.id.cardTitle6)
        val cardContent6 = view.findViewById<LinearLayout>(R.id.cardContent6)
        cardTitle6.setOnClickListener {
            if (cardContent6.visibility == View.GONE) {
                cardContent6.visibility = View.VISIBLE
                cardContent6.alpha = 0f
                cardContent6.animate().alpha(1f).setDuration(300).start()
            } else {
                cardContent6.animate().alpha(0f).setDuration(200).withEndAction {
                    cardContent6.visibility = View.GONE
                }.start()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}