package harshbarash.github.siriustwo.data.fragments.add

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentAdditionallyBinding


class AdditionallyFragment : Fragment(R.layout.fragment_additionally) {


    private lateinit var binding: FragmentAdditionallyBinding

    var additionallyPrice:Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdditionallyBinding.bind(view)

        val args: AdditionallyFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val room = args.room
        val toilet = args.toilet
        val price = args.price

        val titleR = ( if(room >= 2)  " Комнаты" else " Комната" )
        val titleS = ( if(toilet >= 2)  " Санузла" else " Санузел" )

        binding.tvRoomToiletTimePrice.text = (room.toString() + titleR + ", " + toilet.toString() + titleS)

        binding.cbWashDishes.setOnCheckedChangeListener { button, b ->
            if (b)
            {
                Log.d("LOG_TAG","TRUE")
                binding.cardWashDishes.setCardBackgroundColor(Color.parseColor("#FFF2E6"))
            }
            else
            {
                Log.d("LOG_TAG","FALSE")
                binding.cardWashDishes.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        binding.cbWashMicrowave.setOnCheckedChangeListener { button, b ->
            if (b)
            {
                Log.d("LOG_TAG","TRUE")
                binding.cardWashMicrowave.setCardBackgroundColor(Color.parseColor("#FFF2E6"))
            }
            else
            {
                Log.d("LOG_TAG","FALSE")
                binding.cardWashMicrowave.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        binding.cbRemoveOdors.setOnCheckedChangeListener { button, b ->
            if (b)
            {
                Log.d("LOG_TAG","TRUE")
                binding.cardRemoveOdors.setCardBackgroundColor(Color.parseColor("#FFF2E6"))
            }
            else
            {
                Log.d("LOG_TAG","FALSE")
                binding.cardRemoveOdors.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        binding.btnonadress.setOnClickListener {

            val WashDishes = binding.cbWashDishes.isChecked
            val WashMicrowave = binding.cbWashMicrowave.isChecked
            val CleaningOfCloathes = binding.cbCleaningOfClothes.isChecked
            val WashBath = binding.cbWashBath.isChecked
            val RemoveScale = binding.cbRemoveScale.isChecked
            val WashPetTray = binding.cbWashPetTray.isChecked
            val CleaningWool = binding.cbCleaningWool.isChecked
            val Removesomething = binding.cbRemovesomething.isChecked
            val Cleaning = binding.cbCleaning.isChecked

            val RemoveOdors = binding.cbRemoveOdors.isChecked
            val DeepToiletCleaning = binding.cbDeepToiletCleaning.isChecked
            val RecoveryAfterBites = binding.cbRecoveryAfterBites.isChecked
            val FurnitureDryCleaning = binding.cbFurnitureDryCleaning.isChecked

            //когда-то мне станет стыдно, а времени будет много todo
            val order = ( if(WashDishes)  "Помыть плиту " else "" ) +
                    ( if(WashMicrowave) "Помыть внутри микроволновки " else "") +
                    ( if(RemoveOdors) "Вывести запахи " else "") +
                    ( if(DeepToiletCleaning) "Глубокая чистка унитаза " else "") +
                    ( if(RecoveryAfterBites) "Восстановление после укусов " else "") +
                    ( if(FurnitureDryCleaning) "Химчистка мебели " else "") +
                    ( if(CleaningOfCloathes) "Химчистка одежды " else "") +
                    ( if(WashBath) "Помыть ванну " else "") +
                    ( if(RemoveScale) "Убрать накипь " else "") +
                    ( if(WashPetTray) "Мытье лотка питомца " else "") +
                    ( if(CleaningWool) "Очистка от шерсти " else "") +
                    ( if(Removesomething) "Убрать что-то ещё " else "") +
                    ( if(Cleaning) "Химчистка одежды " else "")

            val orderPrice = ( if(WashDishes)  320 else 0 ) +
                    ( if(WashMicrowave) 120 else 0 ) +

                    ( if(RemoveOdors) 500 else 0 ) +
                    ( if(DeepToiletCleaning) 500 else 0 ) +
                    ( if(RecoveryAfterBites) 120 else 0 ) +
                    ( if(FurnitureDryCleaning) 500 else 0 ) +


                    ( if(CleaningOfCloathes) 320 else 0) +
                    ( if(WashBath) 320 else 0) +
                    ( if(RemoveScale) 800 else 0) +
                    ( if(WashPetTray) 320 else 0) +
                    ( if(CleaningWool) 120 else 0) +
                    ( if(Removesomething) 320 else 0) +
                    ( if(Cleaning) 500 else 0)

            val orderTimeNOW = (( if(WashDishes)  20 else 0 ) +
                    ( if(WashMicrowave) 20 else 0 ) +
                    ( if(RemoveOdors) 20 else 0 ) +
                    ( if(DeepToiletCleaning) 40 else 0 ) +
                    ( if(RecoveryAfterBites) 10 else 0 ) +
                    ( if(FurnitureDryCleaning) 20 else 0 ) +
                    ( if(CleaningOfCloathes) 20 else 0) +
                    ( if(WashBath) 15 else 0) +
                    ( if(RemoveScale) 30 else 0) +
                    ( if(WashPetTray) 10 else 0) +
                    ( if(CleaningWool) 10 else 0) +
                    ( if(Removesomething) 10 else 0) +
                    ( if(Cleaning) 20 else 0)) /60

            val args: AdditionallyFragmentArgs by navArgs()
            val roomandtoilet = args.roomandtoilet
            val room = args.room
            val toilet = args.toilet
            val price = args.price

            binding.debugbro.text = order
            binding.tvprice.text = ( price + orderPrice).toString()
            binding.tvtime.text = (orderTimeNOW + roomandtoilet).toString()



            dataTransmission()
        }
    }

        private fun dataTransmission() {

        val args: AdditionallyFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room
        val toilet = args.toilet
        val order = binding.debugbro.text.toString()
        val orderPrice = binding.tvprice.text.toString()
        val orderTime = binding.tvtime.text.toString()



        val action = AdditionallyFragmentDirections.actionAdditionallyFragmentToAdressFragment(
            roomandtoilet,
            price,
            room,
            toilet,
            order,
            orderPrice,
            orderTime
        )

        findNavController().navigate(action)
    }
}