package fe.android.span.helper.compose.material3

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.SpanStyle
import fe.android.span.helper.LinkAnnotationStyle

public object LinkAnnotationStyleDefaults {
    public val primary: LinkAnnotationStyle
        @Composable
        @ReadOnlyComposable get() = LinkAnnotationStyle(
            style = SpanStyle(color = MaterialTheme.colorScheme.primary)
        )
}
