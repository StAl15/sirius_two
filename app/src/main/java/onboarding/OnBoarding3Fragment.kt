package harshbarash.github.siriustwo.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentOnBoarding3Binding


class OnBoarding3Fragment : Fragment(R.layout.fragment_on_boarding3) {

    private lateinit var binding: FragmentOnBoarding3Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnBoarding3Binding.bind(view)

//        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnnext3.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_mainFragment)
            onBoardingFinished()
        }

    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}