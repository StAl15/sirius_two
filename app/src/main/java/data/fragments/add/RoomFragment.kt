package harshbarash.github.siriustwo.data.fragments.add

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentRoomBinding

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
        val array_radio: Array<RadioButton> = arrayOf(
            binding.oneRoom, binding.twoRoom, binding.threeRoom, binding.fourRoom,
            binding.oneT, binding.twoT, binding.threeT, binding.fourT
        )

        //только что вспомнил что нельзя выбирать все
        for (n in array_radio) {
            n.setOnClickListener {
                if (n.currentTextColor != Color.WHITE) {
                    n.setTextColor(Color.WHITE)
                    n.setBackgroundResource(R.drawable.ic_rect_num_room_blue)
                } else {
                    n.setTextColor(Color.parseColor("#3656F9"))
                    n.setBackgroundResource(R.drawable.ic_rect_num_room)
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

            val titleH = (if (textRoom + textToilet >= 2) " часа" else " час")

            binding.tvtime.text = ("≈ " + (textRoom + textToilet) + titleH).toString()

            binding.rgToilet.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    binding.oneT.id -> textToilet = binding.oneT.text.toString().toInt()
                    binding.twoT.id -> textToilet = binding.twoT.text.toString().toInt()
                    binding.threeT.id -> textToilet = binding.threeT.text.toString().toInt()
                    binding.fourT.id -> textToilet = binding.fourT.text.toString().toInt()

                }

                val titleH = (if (textRoom + textToilet >= 2) " часа" else " час")

//                binding.tvtime.text = textRoom.toString()
                binding.tvtime.text = ("≈ " + (textRoom + textToilet) + titleH).toString()

                val roomandtoilet = textRoom + textToilet
                var price: Int = 650
                if (roomandtoilet < 3) {
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

