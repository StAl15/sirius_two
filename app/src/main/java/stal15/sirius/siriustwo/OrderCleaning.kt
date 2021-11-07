package stal15.sirius.siriustwo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView


class OrderCleaning : Fragment(R.layout.fragment_order_cleaning) {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val btn_back: ImageView = view.findViewById(R.id.back_btn_order)
        btn_back.setOnClickListener {
//            findNavController().navigate(R.id.action_orderCleaning_to_mainFragment)
        }

//        var tv_num: TextView = view.findViewById(R.id.textView8)
//        var rect_num: ImageView = view.findViewById(R.id.imageView14)
//        tv_num.setOnClickListener {
//            if (tv_num.currentTextColor == Color.WHITE) {
//                tv_num.setTextColor(Color.parseColor("#3656F9"))
//                rect_num.setImageResource(R.drawable.ic_rect_num_room)
//            } else {
//                tv_num.setTextColor(Color.WHITE)
//                rect_num.setImageResource(R.drawable.ic_rect_num_room_blue)
//            }
//        }


    }

}