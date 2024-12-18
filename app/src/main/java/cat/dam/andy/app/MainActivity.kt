package cat.dam.andy.app
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import cat.dam.andy.app.ui.theme.AppTheme
import cat.dam.andy.app.ui.navigation.NavigationHost
import cat.dam.andy.app.ui.screens.shared.TopMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val selectedButton = rememberSaveable { mutableIntStateOf(1) }
    AppTheme {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize()
        ) {
            TopMenu(navController = navController, selectedButton = selectedButton)
            NavigationHost(navController = navController)
        }
    }
}