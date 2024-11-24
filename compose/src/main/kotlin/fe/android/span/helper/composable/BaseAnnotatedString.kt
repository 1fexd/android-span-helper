package fe.android.span.helper.composable

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.core.text.toSpanned
import fe.android.span.helper.LinkAnnotationStyle
import fe.android.span.helper.LocalLinkAnnotationStyle
import fe.android.span.helper.ext.format
import fe.android.span.helper.ext.handleSpanned

@Composable
public fun createAnnotatedString(
    @StringRes id: Int,
    vararg formatArgs: Any?,
    style: LinkAnnotationStyle? = null,
    options: LinkOptions = LinkOptions(),
): AnnotatedString {
    return buildAnnotatedString {
        fromStringRes(id, *formatArgs, style = style, options = options)
    }
}

@Composable
public fun AnnotatedString.Builder.fromStringRes(
    @StringRes id: Int,
    vararg formatArgs: Any?,
    style: LinkAnnotationStyle? = null,
    options: LinkOptions = LinkOptions(),
): AnnotatedString.Builder {
    val resources = LocalContext.current.resources
    val density = LocalDensity.current
    val linkStyle = style ?: LocalLinkAnnotationStyle.current

    val spanned = remember(id, formatArgs) {
        resources.getText(id).toSpanned().format(*formatArgs)
    }

    return handleSpanned(spanned, density, linkStyle, options)
}

public class LinkOptions(
    public val urlAnnotationKey: String = "url",
    public val urlIdAnnotationKey: String = "url-id",
    public val urlIds: Map<String, String> = emptyMap(),
)
