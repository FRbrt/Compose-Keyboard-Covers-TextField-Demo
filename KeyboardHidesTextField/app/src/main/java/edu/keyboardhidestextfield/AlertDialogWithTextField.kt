package edu.keyboardhidestextfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogWithTextField(openTextFieldCoveredDialog: MutableState<Boolean>) {
    if (openTextFieldCoveredDialog.value) {
        AlertDialog(
            onDismissRequest = { openTextFieldCoveredDialog.value = false },
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxHeight()
                .fillMaxWidth(),
            properties = DialogProperties(
                dismissOnBackPress = true,
                usePlatformDefaultWidth = false,
                dismissOnClickOutside = true,
                decorFitsSystemWindows = false,
            ),
        ) {
            DialogWithTextFieldContent()
        }
    }
}
