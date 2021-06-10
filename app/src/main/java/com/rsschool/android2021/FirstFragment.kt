package com.rsschool.android2021

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private var generateButton: Button? = null
    private var previousResult: TextView? = null

    private var minValueEditText: EditText? = null
    private var maxValueEditText: EditText? = null

    private var listener: ActionPerformedListenerFirstFragment? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ActionPerformedListenerFirstFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"

        // TODO: val min = ...
        // TODO: val max = ...
        minValueEditText = view.findViewById(R.id.min_value)
        maxValueEditText = view.findViewById(R.id.max_value)



        generateButton?.setOnClickListener {
            // TODO: send min and max to the SecondFragment
            val min:Int = isCorrect(minValueEditText?.text.toString())

            val max:Int = isCorrect(maxValueEditText?.text.toString())
            if (min<=max)
            listener?.onActionPerformedFirsFragment(min,max)
        }
    }

    private fun isCorrect(editTextString: String) :Int {
        return if (editTextString.isBlank())
            0
        else
            try {
                editTextString.toInt()
            }
            catch (e: Exception) {
                0
            }

    }

    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"
    }
    interface ActionPerformedListenerFirstFragment{
        fun onActionPerformedFirsFragment(min: Int, max: Int)
    }
}