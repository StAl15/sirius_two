package stal15.sirius.siriustwo.data.fragments.add

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import stal15.sirius.siriustwo.R
import stal15.sirius.siriustwo.databinding.FragmentRoomBinding

class RoomFragment : Fragment(R.layout.fragment_room) {

    private lateinit var binding: FragmentRoomBinding
    var textRoom: Int = 1
    var textToilet: Int = 1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoomBinding.bind(view)

        binding.btntoadditionaly.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

        //genius
        val array_radio_room: Array<RadioButton> = arrayOf(
            binding.oneRoom, binding.twoRoom, binding.threeRoom, binding.fourRoom,
            binding.oneT, binding.twoT, binding.threeT, binding.fourT
        )
        val array_radio_toiletts: Array<RadioButton> = arrayOf(
            binding.oneT, binding.twoT, binding.threeT, binding.fourT
        )


        //только что вспомнил что нельзя выбирать все
        for (n in array_radio_room.indices) {
            array_radio_room[n].setOnClickListener {
                if (array_radio_room[n].currentTextColor != Color.WHITE) {
                    array_radio_room[n].setTextColor(Color.WHITE)
                    array_radio_room[n].setBackgroundResource(R.drawable.ic_rect_num_room_blue)
                    for (i in array_radio_room.indices){
                        if (i!=n && i<=3){
                            array_radio_room[i].setTextColor(Color.parseColor("#3656F9"))
                            array_radio_room[i].setBackgroundResource(R.drawable.ic_rect_num_room)
                        }
                    }
                } else {
                    array_radio_room[n].setTextColor(Color.parseColor("#3656F9"))
                    array_radio_room[n].setBackgroundResource(R.drawable.ic_rect_num_room)
                }
            }
        }

        for (n in array_radio_toiletts.indices) {
            array_radio_toiletts[n].setOnClickListener {
                if (array_radio_toiletts[n].currentTextColor != Color.WHITE) {
                    array_radio_toiletts[n].setTextColor(Color.WHITE)
                    array_radio_toiletts[n].setBackgroundResource(R.drawable.ic_rect_num_room_blue)
                    for (i in array_radio_toiletts.indices){
                        if (i!=n && i<=3){
                            array_radio_toiletts[i].setTextColor(Color.parseColor("#3656F9"))
                            array_radio_toiletts[i].setBackgroundResource(R.drawable.ic_rect_num_room)
                        }
                    }
                } else {
                    array_radio_toiletts[n].setTextColor(Color.parseColor("#3656F9"))
                    array_radio_toiletts[n].setBackgroundResource(R.drawable.ic_rect_num_room)
                }
            }
        }



        binding.rgRoom.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                binding.oneRoom.id -> textRoom = binding.oneRoom.text.toString().toInt()
                binding.twoRoom.id -> textRoom = binding.twoRoom.text.toString().toInt()
                binding.threeRoom.id -> textRoom = binding.threeRoom.text.toString().toInt()
                binding.fourRoom.id -> textRoom = binding.fourRoom.text.toString().toInt()



            }
            var titleH = (if (textRoom + textToilet >= 2) " часа" else " час")

//                binding.tvtime.text = textRoom.toString()
            binding.tvtime.text = ("≈ " + (textRoom + textToilet) + titleH).toString()

            var roomandtoilet = textRoom + textToilet
            var price: Int = 650
            if (roomandtoilet <= 3) {
                price = 650
            } else {
                price = roomandtoilet * 200
            }

            binding.tvprice.text = (price.toString() + "₽")

            //val titleH = (if (textRoom + textToilet >= 2) " часа" else " час")

            binding.tvtime.text = ("≈ " + (textRoom + textToilet) + titleH).toString()

            binding.rgToilet.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    binding.oneT.id -> textToilet = binding.oneT.text.toString().toInt()
                    binding.twoT.id -> textToilet = binding.twoT.text.toString().toInt()
                    binding.threeT.id -> textToilet = binding.threeT.text.toString().toInt()
                    binding.fourT.id -> textToilet = binding.fourT.text.toString().toInt()

                }

                titleH = (if (textRoom + textToilet >= 2) " часа" else " час")

//                binding.tvtime.text = textRoom.toString()
                binding.tvtime.text = ("≈ " + (textRoom + textToilet) + titleH).toString()

                roomandtoilet = textRoom + textToilet
                price = 650
                if (roomandtoilet <= 3) {
                    price = 650
                } else {
                    price = roomandtoilet * 200
                }

                binding.tvprice.text = (price.toString() + "₽")


            }
        }
    }

    private fun dataTransmission() {


        val roomandtoilet = textRoom + textToilet
        var price : Int = 650
        if (roomandtoilet < 3) {
            price=650
        } else {
            price = roomandtoilet * 200
        }

        val room = textRoom
        val toilet = textToilet


        val action = RoomFragmentDirections.actionRoomFragmentToAdditionallyFragment(
            roomandtoilet,
            price,
            room,
            toilet
        )

        findNavController().navigate(action)

    }
}

