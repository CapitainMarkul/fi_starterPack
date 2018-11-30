package sbis.faceinfo.presentation.detailinfo.view

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import sbis.data.model.presentation.ItemParam
import sbis.data.model.presentation.Param
import sbis.faceinfo.R
import sbis.helpers.view.circle.CustomCircle

@BindingAdapter("user_photo")
fun CircleImageView.userPhoto(imgUrl: String?) {
    Picasso.get()
        .load(imgUrl)
        .placeholder(R.drawable.user_stub)
        .error(R.drawable.user_stub)
//        .memoryPolicy(MemoryPolicy.NO_CACHE)
//        .networkPolicy(NetworkPolicy.NO_CACHE)
        .into(this)
}

@BindingAdapter("img_selector")
fun ImageView.setParamImg(itemParam: Param?) {
    itemParam?.let {
        val drawableId = when (itemParam) {
            Param.PUNCTUALITY -> R.drawable.ic_punctual
            Param.PROCRASTINATION -> R.drawable.ic_procrastination
            Param.SOCIABILITY -> R.drawable.ic_sociable
            Param.RESPONSIBILITY -> R.drawable.ic_responsible
        }

        setImageDrawable(context.getDrawable(drawableId))
    }
}

@BindingAdapter("cc_setup")
fun CustomCircle.circleSetup(itemParam: ItemParam?) {
    itemParam?.let {
        setTextSize(16F)
        setTextColor(R.color.colorPrimary)
        setPadding(4F)
        setParamValue(itemParam.value)
        setInverseColors(itemParam.param.isNegative)

        invalidate()
    }
}