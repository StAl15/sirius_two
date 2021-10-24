package harshbarash.github.siriustwo.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        binding = FragmentViewPagerBinding.bind(view)


        val fragmenList = arrayListOf<Fragment>(
            OnBoarding1Fragment(),
            OnBoarding2Fragment(),
            OnBoarding3Fragment()
        )

        val adapter = ViewPagerAdapter(
            fragmenList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter


        return view
    }

}