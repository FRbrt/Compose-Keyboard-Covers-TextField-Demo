package edu.keyboardhidestextfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import edu.keyboardhidestextfield.ui.theme.KeyboardHidesTextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            KeyboardHidesTextFieldTheme {
                val openTextFieldCoveredDialog = remember { mutableStateOf(false) }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center,
                ) {
                    AlertDialogWithTextField(openTextFieldCoveredDialog)
                    Button(
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .fillMaxWidth(0.75f)
                            .align(Alignment.Center)
                            .height(100.dp),
                        onClick = { openTextFieldCoveredDialog.value = true },
                    ) {
                        Text(
                            text = "Show dialog",
                        )
                    }
                }
            }
        }
    }
}
