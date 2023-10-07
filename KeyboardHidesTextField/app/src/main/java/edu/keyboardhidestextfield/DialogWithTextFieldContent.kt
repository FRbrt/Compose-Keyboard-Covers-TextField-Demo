package edu.keyboardhidestextfield

import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.WindowCompat
import edu.keyboardhidestextfield.ui.theme.KeyboardHidesTextFieldTheme
import edu.keyboardhidestextfield.ui.theme.LightYellow


@Composable
fun DialogWithTextFieldContent() {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    val textFieldValueState = remember { mutableStateOf(TextFieldValue("12345")) }

    val windowProvider = LocalView.current.parent as? DialogWindowProvider
    val window = windowProvider?.window
    LaunchedEffect(imeState.value) {
        window?.let { wnd ->
            WindowCompat.setDecorFitsSystemWindows(wnd, false)
            wnd.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }
        if (imeState.value) {
            scrollState.scrollTo(scrollState.maxValue)
        }
    }

    val screenHeightDp = LocalConfiguration.current.screenHeightDp
    val boxHeight = (screenHeightDp * 0.75).dp

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(scrollState),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(boxHeight)
                .background(LightYellow)
        ) {

        }

        CustomTextField(textFieldValueState = textFieldValueState)
    }
}

@Preview
@Composable
fun TextFieldCoveredPreview() {
    KeyboardHidesTextFieldTheme {
        DialogWithTextFieldContent()
    }
}
