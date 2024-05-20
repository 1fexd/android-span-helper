package fe.android.span.helper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import fe.android.span.helper.composable.createAnnotatedString
import fe.android.span.helper.compose.material3.LinkAnnotationStyleDefaults


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Text(text = createAnnotatedString(id = R.string.test_string))
                Text(text = createAnnotatedString(id = R.string.test_string_format, "helo"))
                Text(text = createAnnotatedString(id = R.string.test_string_format_annotated, "yeet"))

                CompositionLocalProvider(LocalLinkAnnotationStyle provides LinkAnnotationStyleDefaults.primary) {
                    Text(text = createAnnotatedString(id = R.string.test_string_format_url, "yeet"))
                }
            }
        }
    }
}
