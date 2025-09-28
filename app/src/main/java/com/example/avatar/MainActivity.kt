package com.example.avatar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarScreen() {
    var tampilAlis by remember { mutableStateOf(true) }
    var tampilMata by remember { mutableStateOf(true) }
    var tampilHidung by remember { mutableStateOf(true) }
    var tampilMulut by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AvatarApp", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE91E63)
                )
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFFFEBEE))
        ) {
            // Avatar utama
            Box(
                modifier = Modifier.size(450.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "Wajah",
                    modifier = Modifier.fillMaxSize()
                )

                if (tampilAlis) {
                    Image(
                        painter = painterResource(R.drawable.rambut),
                        contentDescription = "Alis",
                        modifier = Modifier
                            .size(200.dp)
                            .offset(y = (-40).dp)
                    )
                }
                if (tampilMata) {
                    Image(
                        painter = painterResource(R.drawable.mata),
                        contentDescription = "Mata",
                        modifier = Modifier
                            .size(180.dp)
                            .offset(y = (-10).dp)
                    )
                }
                if (tampilHidung) {
                    Image(
                        painter = painterResource(R.drawable.hidung),
                        contentDescription = "Hidung",
                        modifier = Modifier
                            .size(50.dp)
                            .offset(y = 35.dp)
                    )
                }
                if (tampilMulut) {
                    Image(
                        painter = painterResource(R.drawable.mulut),
                        contentDescription = "Mulut",
                        modifier = Modifier
                            .size(80.dp)
                            .offset(y = 80.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(100.dp))

            // Checkbox baris horizontal
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                CheckItem("Brow", tampilAlis) { tampilAlis = it }
                CheckItem("Eye", tampilMata) { tampilMata = it }
                CheckItem("Nose", tampilHidung) { tampilHidung = it }
                CheckItem("Mouth", tampilMulut) { tampilMulut = it }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun CheckItem(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 6.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFFF9800),
                uncheckedColor = Color.Gray
            ),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(label, fontSize = 16.sp)
    }
}
