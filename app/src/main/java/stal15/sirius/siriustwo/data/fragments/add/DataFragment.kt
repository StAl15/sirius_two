package stal15.sirius.siriustwo.data.fragments.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import stal15.sirius.siriustwo.R
import stal15.sirius.siriustwo.data.fragments.add.ViewPagerData.ViewPagerDataAdapter
import stal15.sirius.siriustwo.data.fragments.add.ViewPagerData.ViewPagerTimeAdapter
import stal15.sirius.siriustwo.databinding.FragmentDataBinding


class DataFragment : Fragment(R.layout.fragment_data) {


    private lateinit var binding: FragmentDataBinding
    val days =
        listOf("1,пн", "2,вт", "3,ср", "4,чт", "5,пт", "6,сб", "7,вс", "8,пн", "9,вт", "10,ср")
    val time_hours =
        listOf("1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00","8:00","9:00","10:00","11:00","12:00",
            "13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","00:00")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDataBinding.bind(view)

        binding.btnNext.setOnClickListener {
            //переход дальше
            dataTransmission()
        }


        val adapter = ViewPagerDataAdapter(days)
        val adapter2 = ViewPagerTimeAdapter(time_hours)
//        binding.dataVP.clipToPadding = false
//        binding.dataVP.clipChildren = false
//        binding.dataVP.offscreenPageLimit = 5
//        binding.dataVP.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//        val compositePageTransformer = CompositePageTransformer()
//        compositePageTransformer.addTransformer(MarginPageTransformer(5))
//        compositePageTransformer.addTransformer { page, position ->
//            var r: Float = 1 - abs(position)
//            page.scaleY = 0.85f + r * 0.15f
//        }
//        binding.dataVP.setPageTransformer(compositePageTransformer)
        binding.dataVP.adapter = adapter
        binding.timeVP.adapter = adapter2


        binding.backAdress.setOnClickListener {
            findNavController().navigate(R.id.action_dataFragment_to_adressFragment)
        }

        val args: DataFragmentArgs by navArgs()
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderTime = args.orderTime.toInt()
        val orderPrice = args.orderPrice

        val titleR = ( if(room < 2) { " Комната" }
        else if (room >= 2 && room < 5) { " Комнаты" }
        else { " Комнат"})

        val titleS = ( if(toilet < 2) { " Санузел" }
        else if (toilet >= 2 && toilet < 5) { " Санузла" }
        else { " Санузлов"})

        val titleH = ( if(orderTime < 2) { " час" }
        else if (orderTime >= 2 && orderTime < 5 ) { " часa" }
        else { " часов"})

        binding.tvRoomToiletTimePriceAdress.text = (room.toString() + titleR + ", " + toilet.toString() + titleS + ", " + orderTime + titleH + ", " + orderPrice +  "₽")
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

        val data = days[binding.dataVP.currentItem]
        val dataTime = time_hours[binding.timeVP.currentItem]

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
        Log.d("DATA_INFO", "current day chose: $data") //проверка
        Log.d("DATA_INFO", "current time chose: $dataTime") //проверка
        findNavController().navigate(action)
    }


}