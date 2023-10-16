package com.android.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.android.designsystem.theme.LbtTheme
import com.android.home.model.HeaderUiModel

@Composable
fun HeaderItem(
    headerUiModel: HeaderUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = headerUiModel.title,
            modifier = Modifier
                .semantics { heading() },
            style = TextStyle.Default,
            color = Color.Black
        )
    }
}
@Preview
@Composable
fun PreviewHeader() {
    LbtTheme {
        HeaderItem(headerUiModel = HeaderUiModel("Home"))
    }
}