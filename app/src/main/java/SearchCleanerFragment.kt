package harshbarash.github.siriustwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class SearchCleanerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_cleaner, container, false)
        val btn_back_search: ImageView = view.findViewById(R.id.back_search_btn)
        btn_back_search.setOnClickListener{

        }
        return view
    }


}