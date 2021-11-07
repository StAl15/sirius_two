package stal15.sirius.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import stal15.sirius.siriustwo.R
import stal15.sirius.siriustwo.databinding.FragmentPaymentBinding


class PayFragment : Fragment(R.layout.fragment_payment) {

    private lateinit var binding: FragmentPaymentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPaymentBinding.bind(view)


        binding.cardToCleanerBtn.setOnClickListener {
            dataTransmission()
        }

        binding.moneyToCleanerBtn.setOnClickListener {
            dataTransmission()
        }

        binding.applePayToCleanerBtn.setOnClickListener {
            dataTransmission()
        }

        binding.googlePayToCleanerBtn.setOnClickListener {
            dataTransmission()
        }

        val args: PayFragmentArgs by navArgs()
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderPrice = args.orderPrice
        val orderTime = args.orderTime.toInt()
        val titleR = ( if(room >= 2)  " Комнаты" else " Комната" )
        val titleS = ( if(toilet >= 2)  " Санузла" else " Санузел" )
        val titleH = ( if(orderTime >= 2)  " часа" else " час" )

        binding.tvRoomToiletTimePriceAdress.text = (room.toString() + titleR + ", " + toilet.toString() + titleS + ", " + orderTime + titleH + ", " + orderPrice +  "₽")
    }

    private fun dataTransmission() {

        val args: PayFragmentArgs by navArgs()
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
        val data = args.data
        val dataTime = args.dataTime

        val action = PayFragmentDirections.actionPayFragmentToOrderFragment(
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