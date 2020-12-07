package app.jetpack.navigation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.jetpack.navigation.databinding.FragmentStudentDetailBinding

class StudentDetailFragment : Fragment() {

    lateinit var binding: FragmentStudentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        binding.nameTV.text = name
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = StudentDetailFragment().apply {
            arguments = Bundle().apply {}
        }
    }
}