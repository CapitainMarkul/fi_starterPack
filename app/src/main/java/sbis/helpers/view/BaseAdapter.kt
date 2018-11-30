package sbis.helpers.view

import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<T : RecyclerView.ViewHolder, MODEL_TYPE> : RecyclerView.Adapter<T>() {

    protected var itemList = listOf<MODEL_TYPE>()

    fun setItems(items: List<MODEL_TYPE>?) {
        itemList = items ?: emptyList()
        notifyDataSetChanged()
    }

    override fun getItemCount() = itemList.size
}