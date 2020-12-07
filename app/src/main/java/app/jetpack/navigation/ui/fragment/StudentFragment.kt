package app.jetpack.navigation.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import app.jetpack.navigation.R
import app.jetpack.navigation.databinding.FragmentStudentBinding
import app.jetpack.navigation.ui.MainActivity


/**
 * A simple [Fragment] subclass.
 * Use the [StudentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentFragment : Fragment() {

    lateinit var binding: FragmentStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStudentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.studentFAB.setOnClickListener {
            val bundle = Bundle().apply {
                putString("name", binding.studentNameET.text.toString())
            }
            (requireActivity() as MainActivity).navController.navigate(R.id.action_studentFragment_to_studentDetailFragment, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = StudentFragment().apply {
            arguments = Bundle().apply {}
        }
    }
}