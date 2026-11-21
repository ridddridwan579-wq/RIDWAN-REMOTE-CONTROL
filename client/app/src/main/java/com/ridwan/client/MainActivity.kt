
package com.ridwan.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                ClientScreen()
            }
        }
    }
}

@Composable
fun ClientScreen() {
    var deviceName by remember { mutableStateOf("") }
    var registered by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "RIDWAN REMOTE",
                fontSize = 26.sp,
                style = MaterialTheme.typography.headlineMedium
            )

            Text("CLIENT DEVICE")

            Spacer(modifier = Modifier.height(28.dp))

            OutlinedTextField(
                value = deviceName,
                onValueChange = { deviceName = it },
                label = { Text("Nama perangkat ini") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    registered = deviceName.isNotBlank()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Daftarkan perangkat")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text("STATUS CLIENT")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        if (registered) {
                            "Nama: $deviceName\nStatus: Menunggu koneksi server"
                        } else {
                            "Perangkat belum didaftarkan"
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Pendaftaran dilakukan secara sadar oleh pengguna perangkat ini.",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
