package ui

import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import javax.swing.JTextField

class PlaceholderTextField(text: String, private val placeholder: String) :
    JTextField(text) {
    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        if (text.isNotEmpty()) return

        (graphics as Graphics2D).setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        )
        graphics.color = disabledTextColor.let { Color(it.red, it.green, it.blue, 128) }
        graphics.drawString(
            placeholder,
            insets.left,
            graphics.fontMetrics.maxAscent + (insets.top + graphics.clipBounds.height - insets.bottom - graphics.fontMetrics.height) / 2
        )
    }
}
