package harshbarash.github.siriustwo.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentOnBoarding2Binding


class OnBoarding2Fragment :  Fragment(R.layout.fragment_on_boarding2) {

    private lateinit var binding: FragmentOnBoarding2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnBoarding2Binding.bind(view)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnnext2.setOnClickListener {
            viewPager?.currentItem = 2
        }
    }
}