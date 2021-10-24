package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentDataBinding


class DataFragment : Fragment(R.layout.fragment_data) {


    private lateinit var binding: FragmentDataBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDataBinding.bind(view)

        binding.btnNext.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

    }

    private fun dataTransmission() {

        val args: DataFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderPrice = args.orderPrice
        val orderTime = args.orderTime
        val city = args.city
        val street = args.street
        val house = args.house
        val flat = args.flat
        val corpus = args.corpus
        val entrance = args.entrance
        val comment = args.comment
        val data = "18.1"
        val dataTime = "18:00"

        val action = DataFragmentDirections.actionDataFragmentToPayFragment(
            roomandtoilet,
            price,
            room,
            toilet,
            order,
            orderPrice,
            orderTime,
            city,
            street,
            house,
            flat,
            corpus,
            entrance,
            comment,
            data,
            dataTime
        )

        findNavController().navigate(action)
    }



}