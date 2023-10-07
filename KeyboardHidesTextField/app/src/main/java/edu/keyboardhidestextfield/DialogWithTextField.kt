package edu.keyboardhidestextfield

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun DialogWithTextField(openTextFieldCoveredDialog: MutableState<Boolean>) {
    if (openTextFieldCoveredDialog.value) {
        Dialog(
            onDismissRequest = { openTextFieldCoveredDialog.value = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                usePlatformDefaultWidth = false,
                dismissOnClickOutside = true,
                decorFitsSystemWindows = false,
            ),
        ) {
            Box(
                modifier = Modifier
                    .sizeIn(minWidth = 260.dp, maxWidth = 560.dp),
                propagateMinConstraints = true
            ) {
                DialogWithTextFieldContent()
            }
        }
    }
}
