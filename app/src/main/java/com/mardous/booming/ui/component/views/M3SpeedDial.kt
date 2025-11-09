package com.mardous.booming.ui.component.views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.color.MaterialColors
import com.leinardi.android.speeddial.FabWithLabelView
import com.leinardi.android.speeddial.SpeedDialActionItem
import com.leinardi.android.speeddial.SpeedDialView
import com.mardous.booming.extensions.dp
import androidx.appcompat.R as CR
import com.google.android.material.R as MR

class M3SpeedDial @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SpeedDialView(context, attrs, defStyleAttr) {

    init {
        mainFabAnimationRotateAngle = 0f
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mainFabClosedBackgroundColor = MaterialColors.getColor(this, MR.attr.colorPrimaryContainer)
        mainFabClosedIconColor = MaterialColors.getColor(this, MR.attr.colorOnPrimaryContainer)
        mainFabOpenedBackgroundColor = MaterialColors.getColor(this, CR.attr.colorPrimary)
        mainFabOpenedIconColor = MaterialColors.getColor(this, MR.attr.colorOnPrimary)
    }

    override fun addActionItem(
        actionItem: SpeedDialActionItem,
        position: Int,
        animate: Boolean
    ): FabWithLabelView? {
        val cornerRadius = 8f.dp(context).toFloat()

        val iconColor = MaterialColors.getColor(this, CR.attr.colorPrimary)
        val backgroundColor = MaterialColors.getColor(this, MR.attr.colorSurfaceContainer)
        val labelColor = MaterialColors.getColor(this, MR.attr.colorOnSurface)
        val labelBackgroundColor = MaterialColors.getColor(this, MR.attr.colorSurfaceContainerLow)

        val actionItem = SpeedDialActionItem.Builder(actionItem.id, actionItem.getFabImageDrawable(context))
            .setLabel(actionItem.getLabel(context))
            .setFabImageTintColor(iconColor)
            .setFabBackgroundColor(backgroundColor)
            .setLabelColor(labelColor)
            .setLabelBackgroundColor(labelBackgroundColor)
            .setLabelClickable(actionItem.isLabelClickable)
            .setTheme(actionItem.theme)
            .create()

        val fabView = super.addActionItem(actionItem, position, animate)
        if (fabView != null) {
            val padding = 8f.dp(context)
            fabView.labelBackground.useCompatPadding = false
            fabView.labelBackground.setContentPadding(padding, padding, padding, padding)
            fabView.labelBackground.radius = cornerRadius
        }
        return fabView
    }
}