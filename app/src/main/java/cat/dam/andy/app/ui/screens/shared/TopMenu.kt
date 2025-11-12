package cat.dam.andy.app.ui.screens.shared
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cat.dam.andy.app.ui.navigation.NavigationConstants.LAYOUT_COUNT

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
                Text("L$index")
            }
        }
    }
}
