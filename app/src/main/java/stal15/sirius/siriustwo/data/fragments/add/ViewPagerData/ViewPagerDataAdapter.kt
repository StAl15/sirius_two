package stal15.sirius.siriustwo.data.fragments.add.ViewPagerData

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import stal15.sirius.siriustwo.R

class ViewPagerDataAdapter(
    val list_days: List<String>
) : RecyclerView.Adapter<ViewPagerDataAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currDay = list_days[position]
        var prevDay: String
        var nextDay: String
        var prePrevDay: String
        var afterNextDay: String

        try {
            afterNextDay = list_days[position+2]
            prePrevDay = list_days[position-2]
            prevDay = list_days[position-1]
            nextDay = list_days[position+1]
        }catch (ex: ArrayIndexOutOfBoundsException){
            prevDay = list_days[list_days.size-1]
            nextDay = list_days[1]
            prePrevDay = list_days[list_days.size-2]
            afterNextDay = list_days[2]
        }

        holder.itemView.findViewById<TextView>(R.id.vp_data_day_1).text = prePrevDay
        holder.itemView.findViewById<TextView>(R.id.vp_data_day_2).text = prevDay
        holder.itemView.findViewById<TextView>(R.id.vp_data_day_3).text = currDay
        holder.itemView.findViewById<TextView>(R.id.vp_data_day_4).text = nextDay
        holder.itemView.findViewById<TextView>(R.id.vp_data_day_5).text = afterNextDay

    }

    override fun getItemCount(): Int {
        return list_days.size
    }
}

class ViewPagerTimeAdapter(
    val list_time: List<String>
) : RecyclerView.Adapter<ViewPagerTimeAdapter.ViewPagerTimeViewHolder>() {

    inner class ViewPagerTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerTimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_view_pager, parent, false)
        return ViewPagerTimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerTimeViewHolder, position: Int) {
        val currTime = list_time[position]
        var prevTime: String
        var nextTime: String
        var prePrevTime: String
        var afterNextTime: String

        try {
            prePrevTime = list_time[position-2]
            prevTime = list_time[position-1]
            nextTime = list_time[position+1]
            afterNextTime = list_time[position+2]
        }catch (ex: ArrayIndexOutOfBoundsException){
            prevTime = list_time[list_time.size-1]
            nextTime = list_time[1]
            prePrevTime = list_time[list_time.size-2]
            afterNextTime = list_time[2]
        }

        holder.itemView.findViewById<TextView>(R.id.vp_data_time_1).text = prePrevTime
        holder.itemView.findViewById<TextView>(R.id.vp_data_time_2).text = prevTime
        holder.itemView.findViewById<TextView>(R.id.vp_data_time_3).text = currTime
        holder.itemView.findViewById<TextView>(R.id.vp_data_time_4).text = nextTime
        holder.itemView.findViewById<TextView>(R.id.vp_data_time_5).text = afterNextTime

    }

    override fun getItemCount(): Int {
        return list_time.size
    }
}