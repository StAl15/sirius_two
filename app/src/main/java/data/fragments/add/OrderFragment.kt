package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.data.Order
import harshbarash.github.siriustwo.data.OrderViewModel
import harshbarash.github.siriustwo.databinding.FragmentOrderBinding
import harshbarash.github.siriustwo.databinding.OrderCleaningToolbarVar2Binding


class OrderFragment : Fragment(R.layout.fragment_order) {


    private lateinit var mOrderViewModel: OrderViewModel

    private lateinit var binding: FragmentOrderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)


        val args: OrderFragmentArgs by navArgs()
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

        val romandtoilet_title: String = "Количество комнат и санузлов"
        val price_title: String = "Цена"
        val room_title: String = "Количество комнат"
        val toilet_title: String = "Количество санузлов"
        val order_title: String = "Заказ"
        val order_price_title: String = "Стоимость услуг"
        val order_time_title: String = "Время выполнения"
        val city_title: String = "Город"
        val street_title: String = "Улица"
        val house_title: String = "Дом"
        val flat_title: String = "Секция"
        val corpus_title: String = "Корпус"
        val entrance_title: String = "Количество комнат и санузлов"
        val comment_title: String = "Комментарий"
        val data_title: String = "Дата"
        val dataTime_title: String = "Время"

        binding.tvRoomToiletTimePriceAdress.text = (city + ", " + street + ", " + house)

        binding.data1.text = data + "      " + dataTime
        binding.data3.text = city + ", " + street + ", д" + house + ", корп " + corpus + ", кв." + flat + " " + entrance
        binding.data5.text = order


        mOrderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        binding.btnonmain.setOnClickListener {
            insertDataToDatabase()
            findNavController().navigate(R.id.action_orderFragment_to_mainFragment)
        }

    }

    private fun insertDataToDatabase() {

        val args: OrderFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room.toString()
        val toilet = args.toilet.toString()
        val order = args.order.toString()
        val orderPrice = args.orderPrice.toString()
        val orderTime = args.orderTime
        val city = args.city.toString()
        val street = args.street.toString()
        val house = args.house.toString()
        val flat = args.flat
        val corpus = args.corpus
        val entrance = args.entrance
        val comment = args.comment
        val data = args.data
        val dataTime = args.dataTime

        val ourorder =
            Order(0, city, street, house, corpus, flat, Integer.parseInt(orderPrice))
        mOrderViewModel.addOrder(ourorder)
    }


}