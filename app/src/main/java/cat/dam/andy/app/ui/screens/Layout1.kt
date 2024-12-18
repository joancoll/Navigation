package cat.dam.andy.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cat.dam.andy.app.ui.theme.AppTheme

@Composable
fun Layout1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text("Layout 1", color = Color.White)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLayout() {
    AppTheme {
        Layout1()
    }
}
