package harshbarash.github.siriustwo.data.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import harshbarash.github.siriustwo.data.Order
import harshbarash.github.siriustwo.databinding.CustomRowBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var orderList = emptyList<Order>()

    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = orderList[position]
        holder.binding.tvOrder.text = "#" + currentItem.id.toString()
        holder.binding.tvPrice.text = currentItem.price.toString() + "₽"
        holder.binding.tvAdress.text = (currentItem.city + "," + currentItem.street + "," + currentItem.house + "," + currentItem.corpus + "," +  currentItem.flat)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    fun setData(order: List<Order>){
        this.orderList = order
        notifyDataSetChanged()
    }
}