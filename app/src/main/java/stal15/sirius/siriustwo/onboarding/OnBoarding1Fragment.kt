package stal15.sirius.siriustwo.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import stal15.sirius.siriustwo.R
import stal15.sirius.siriustwo.databinding.FragmentOnBoarding1Binding

class OnBoarding1Fragment : Fragment(R.layout.fragment_on_boarding1) {

    private lateinit var binding: FragmentOnBoarding1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnBoarding1Binding.bind(view)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnnext.setOnClickListener {
            viewPager?.currentItem = 1
        }
    }
}
