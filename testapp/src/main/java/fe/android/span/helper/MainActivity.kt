package fe.android.span.helper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.SpanStyle
import fe.android.span.helper.composable.createAnnotatedString


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Text(text = createAnnotatedString(id = R.string.test_string))
                Text(text = createAnnotatedString(id = R.string.test_string_format, "helo"))
                Text(text = createAnnotatedString(id = R.string.test_string_format_annotated, "yeet"))

                CompositionLocalProvider(
                    LocalLinkAnnotationStyle provides LinkAnnotationStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary))
                ) {
                    Text(text = createAnnotatedString(id = R.string.test_string_format_url, "yeet"))
                }
            }
        }
    }
}
