package dzmitryk.app.template.ui.hello

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dzmitryk.app.template.ui.theme.AppTemplateTheme
import kotlinx.coroutines.delay

val rainbowColors = listOf(
    Color(0xFFE74C3C), // Red
    Color(0xFFF39C12), // Orange
    Color(0xFFF1C40F), // Yellow
    Color(0xFF2ECC71), // Green
    Color(0xFF3498DB), // Blue
    Color(0xFF8E44AD), // Indigo
    Color(0xFF9B59B6)  // Violet
)

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}


@Composable
fun RainbowColorChangeText(text: String, modifier: Modifier = Modifier) {
    var currentColorIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(500)
            currentColorIndex = (currentColorIndex + 1) % rainbowColors.size
        }
    }

    Text(
        modifier = modifier,
        text = text,
        color = rainbowColors[currentColorIndex],
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RainbowColorText(modifier: Modifier = Modifier, text: String) {
    Row(modifier = modifier) {
        text.forEachIndexed { index, char ->
            Text(
                text = char.toString(),
                color = rainbowColors[index % rainbowColors.size],
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RainbowAnnotated(modifier: Modifier = Modifier, text: String) {
    val annotatedText = buildAnnotatedString {
        text.forEachIndexed { index, char ->
            withStyle(style = SpanStyle(color = rainbowColors[index % rainbowColors.size])) {
                append(char)
            }
        }
    }
    Text(
        text = annotatedText,
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTemplateTheme {
        Greeting(text = "Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun RainbowTextPreview() {
    AppTemplateTheme {
        RainbowColorChangeText(text = "Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun RainbowColorTextPreview() {
    AppTemplateTheme {
        RainbowColorText(text = "Hello World")
    }
}