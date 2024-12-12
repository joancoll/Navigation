package cat.dam.andy.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import cat.dam.andy.navigation.ui.theme.AppTheme

const val LAYOUT_COUNT = 4 // Number of layouts

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

@Composable
fun TopMenu(navController: NavHostController, selectedButton: MutableState<Int>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        (1..LAYOUT_COUNT).forEach { index ->
            Button(
                onClick = {
                    navController.navigate("layout$index") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                    selectedButton.value = index
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton.value == index) Color.Blue else Color.LightGray
                ),
                shape = RoundedCornerShape(50)
            ) {
                Text("Layout$index")
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "layout1") {
        composable("layout1") { Layout1() }
        composable("layout2") { Layout2() }
        composable("layout3") { Layout3() }
        composable("layout4") { Layout4() }
    }
}

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
fun Layout2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text("Layout 2", color = Color.White)
    }
}

@Composable
fun Layout3() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Text("Layout 3", color = Color.Black)
    }
}

@Composable
fun Layout4() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text("Layout 4", color = Color.Black)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLayout() {
    AppTheme {
        Layout1()
    }
}