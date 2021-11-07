package stal15.sirius.siriustwo.data.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import stal15.sirius.siriustwo.R
import stal15.sirius.siriustwo.databinding.FragmentAdressBinding


class AdressFragment : Fragment(R.layout.fragment_adress) {

    private lateinit var binding: FragmentAdressBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdressBinding.bind(view)

        binding.btnontime.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

        binding.backAdress.setOnClickListener{
            findNavController().navigate(AdressFragmentDirections.actionAdressFragmentToAdditionallyFragment())
        }
        binding.infoAdress.setOnClickListener{
            Toast.makeText(requireContext(), "Адрес доставки", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener{
            Toast.makeText(requireContext(), "Карты временно заблокированы", Toast.LENGTH_SHORT).show()
        }

        val args: AdressFragmentArgs by navArgs()
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

        val args: AdressFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderPrice = args.orderPrice
        val orderTime = args.orderTime

        val city = binding.etCity.text.toString()
        val street = binding.etStreet.text.toString()
        val house = binding.etHome.text.toString()
        val flat = binding.etFlat.text.toString()
        val corpus = binding.etCorpus.text.toString()
        val entrance = binding.etEntrance.text.toString()
        val comment = binding.etComment.text.toString()

        if (inputCheck(city, street, house, flat)){

            val action = AdressFragmentDirections.actionAdressFragmentToDataFragment(
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
                comment
            )

            findNavController().navigate(action)

        } else {
            Toast.makeText(requireContext(), "Пожалуйста введите Город, Улицу, Дом и Квартиру обязательно", Toast.LENGTH_SHORT).show()
        }


    }

    private fun inputCheck(city: String, street: String, house: String, flat: String):Boolean{
        return !(TextUtils.isEmpty(city) && TextUtils.isEmpty(street) && TextUtils.isEmpty(house) && TextUtils.isEmpty(flat) )
    }



}