package sbis.faceinfo.presentation.detailinfo.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sbis.data.model.presentation.ItemParam
import sbis.faceinfo.R
import sbis.faceinfo.databinding.ItemPersonParamBinding
import sbis.helpers.view.BaseAdapter

class DetailParamsAdapter : BaseAdapter<DetailParamsAdapter.ViewHolder, ItemParam>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_person_param, parent, false)
            )!!
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = itemList[position]
        holder.bind(person)
    }

    class ViewHolder(val bindView: ItemPersonParamBinding) : RecyclerView.ViewHolder(bindView.root) {

        fun bind(viewModel: ItemParam) {
            bindView.viewModel = viewModel

            val minParamValue = 0F
            val maxParamValue = 100F
//            bindView.sbParam.apply {
//                setMin(minParamValue)
//                setMax(maxParamValue)
//                currentValue = viewModel.value.toFloat()
//            }

            bindView.executePendingBindings()
        }
    }
}