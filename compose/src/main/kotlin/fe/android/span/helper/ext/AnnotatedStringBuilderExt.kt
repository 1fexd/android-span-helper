package fe.android.span.helper.ext

import android.text.Annotation
import android.text.ParcelableSpan
import android.text.Spanned
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Density
import fe.android.span.helper.LinkAnnotationStyle
import fe.android.span.helper.util.toSpanStyle


public fun AnnotatedString.Builder.handleSpanned(
    spanned: Spanned,
    density: Density,
    urlLinkStyle: LinkAnnotationStyle,
    urlAnnotationKey: String = "url",
): AnnotatedString.Builder {
    append(spanned)

    for ((span, range) in spanned.getAllParcelableSpans()) {
        putSpan(span, density, urlLinkStyle, urlAnnotationKey, range.first, range.last)
    }

    return this
}

public fun AnnotatedString.Builder.putSpan(
    span: ParcelableSpan,
    density: Density,
    urlLinkStyle: LinkAnnotationStyle,
    urlAnnotationKey: String = "url",
    start: Int,
    end: Int,
) {
    when (span) {
        !is Annotation -> addStyle(span.toSpanStyle(density), start, end)
        else -> {
            if (span.key == urlAnnotationKey) {
                addLink(urlLinkStyle.toUrlAnnotation(span.value), start, end)
            }
        }
    }
}
