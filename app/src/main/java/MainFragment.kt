package harshbarash.github.siriustwo

import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import harshbarash.github.siriustwo.data.OrderViewModel
import harshbarash.github.siriustwo.data.fragments.list.ListAdapter
import harshbarash.github.siriustwo.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var mOrderViewModel: OrderViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        //rv
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Viewmodel
        mOrderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        mOrderViewModel.readAllData.observe(
            viewLifecycleOwner,
            Observer { order -> adapter.setData(order) })

        binding.rectBuy.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_roomFragment)
        }

        binding.btnBuyNextMain.visibility = View.INVISIBLE
        binding.actualBtn.setOnClickListener {
            if (mOrderViewModel.readAllData.value?.isEmpty() == false) {
                binding.btnBuyNextMain.visibility = View.VISIBLE
                binding.actualBtn.setTextColor(resources.getColor(R.color.activeBottomNavIconColor))
                binding.completedBtn.setTextColor(Color.parseColor("#C6CFFF"))
                binding.womanClear.visibility = View.INVISIBLE
                binding.rectBuy.visibility = View.INVISIBLE
                binding.purchaiseTv.visibility = View.INVISIBLE
                binding.imageView4.visibility = View.INVISIBLE
                binding.textView4.visibility = View.INVISIBLE
                binding.imageView5.visibility = View.INVISIBLE
                binding.textView3.visibility = View.INVISIBLE
                binding.textView2.visibility = View.INVISIBLE
                binding.imageView3.visibility = View.INVISIBLE
                binding.imageView7.visibility = View.INVISIBLE
                binding.recyclerview.visibility = View.VISIBLE

                binding.viewActual.visibility = View.INVISIBLE
                binding.viewCompleted.visibility = View.VISIBLE

            } else {
                binding.btnBuyNextMain.visibility = View.INVISIBLE
                binding.actualBtn.setTextColor(resources.getColor(R.color.activeBottomNavIconColor))
                binding.completedBtn.setTextColor(Color.parseColor("#C6CFFF"))
                binding.womanClear.visibility = View.VISIBLE
                binding.rectBuy.visibility = View.VISIBLE
                binding.purchaiseTv.visibility = View.VISIBLE
                binding.imageView4.visibility = View.VISIBLE
                binding.textView4.visibility = View.VISIBLE
                binding.imageView5.visibility = View.VISIBLE
                binding.textView3.visibility = View.VISIBLE
                binding.textView2.visibility = View.VISIBLE
                binding.imageView3.visibility = View.VISIBLE
                binding.imageView7.visibility = View.VISIBLE
                binding.recyclerview.visibility = View.INVISIBLE

                binding.viewActual.visibility = View.VISIBLE
                binding.viewCompleted.visibility = View.INVISIBLE
            }
        }
        binding.completedBtn.setOnClickListener {
            binding.btnBuyNextMain.visibility = View.INVISIBLE
            binding.completedBtn.setTextColor(resources.getColor(R.color.activeBottomNavIconColor))
            binding.actualBtn.setTextColor(Color.parseColor("#C6CFFF"))
            binding.womanClear.visibility = View.VISIBLE
            binding.rectBuy.visibility = View.VISIBLE
            binding.purchaiseTv.visibility = View.VISIBLE
            binding.imageView4.visibility = View.VISIBLE
            binding.textView4.visibility = View.VISIBLE
            binding.imageView5.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
            binding.textView2.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.imageView7.visibility = View.VISIBLE
            binding.recyclerview.visibility = View.INVISIBLE

            binding.viewActual.visibility = View.VISIBLE
            binding.viewCompleted.visibility = View.INVISIBLE
        }

        if (mOrderViewModel.readAllData.value?.isNullOrEmpty() == false) {
            binding.btnBuyNextMain.visibility = View.VISIBLE
            binding.womanClear.visibility = View.INVISIBLE
            binding.rectBuy.visibility = View.INVISIBLE
            binding.purchaiseTv.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.textView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.textView3.visibility = View.INVISIBLE
            binding.textView2.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.recyclerview.visibility = View.VISIBLE

        } else {
            binding.btnBuyNextMain.visibility = View.INVISIBLE
            binding.womanClear.visibility = View.VISIBLE
            binding.rectBuy.visibility = View.VISIBLE
            binding.purchaiseTv.visibility = View.VISIBLE
            binding.imageView4.visibility = View.VISIBLE
            binding.textView4.visibility = View.VISIBLE
            binding.imageView5.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
            binding.textView2.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.imageView7.visibility = View.VISIBLE
            binding.recyclerview.visibility = View.INVISIBLE
        }
    }

}
