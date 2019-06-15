package com.vshkl.coins.utils.svg

import com.bumptech.glide.request.target.ImageViewTarget
import com.bumptech.glide.request.target.Target
import android.graphics.drawable.PictureDrawable
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener

class SvgSoftwareLayerSetter : RequestListener<PictureDrawable> {

    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<PictureDrawable>?,
        isFirstResource: Boolean
    ): Boolean = applyLayerType(target, ImageView.LAYER_TYPE_NONE)

    override fun onResourceReady(
        resource: PictureDrawable,
        model: Any,
        target: Target<PictureDrawable>,
        dataSource: DataSource,
        isFirstResource: Boolean
    ): Boolean = applyLayerType(target, ImageView.LAYER_TYPE_SOFTWARE)

    private fun applyLayerType(target: Target<PictureDrawable>?, layerType: Int): Boolean {
        (target as ImageViewTarget<*>)
            .view
            .setLayerType(layerType, null)
        return false
    }
}