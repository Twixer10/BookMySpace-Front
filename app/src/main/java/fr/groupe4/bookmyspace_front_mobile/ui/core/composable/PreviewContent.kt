package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.BookMySpaceTheme


@Composable
fun PreviewContent(content: @Composable BoxScope.() -> Unit) {
    BookMySpaceTheme {
        Box(modifier = Modifier.background(Color.White), content = content)
    }
}

@Composable
fun PreviewContent(
    spacingVertical: Dp,
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(spacingVertical),
    content: @Composable ColumnScope.() -> Unit
) {
    BookMySpaceTheme {
        Column(
            modifier = Modifier.background(Color.White),
            verticalArrangement = verticalArrangement,
            content = content
        )
    }
}

@Composable
fun PreviewContent(
    spacingHorizontal: Dp,
    horizontalArrangement: Arrangement.Horizontal =  Arrangement.spacedBy(spacingHorizontal),
    content: @Composable RowScope.() -> Unit
) {
    BookMySpaceTheme {
        Row(
            modifier = Modifier.background(Color.White),
            horizontalArrangement = horizontalArrangement,
            content = content
        )
    }

}