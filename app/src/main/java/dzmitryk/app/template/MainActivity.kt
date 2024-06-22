package dzmitryk.app.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dzmitryk.app.template.ui.hello.Greeting
import dzmitryk.app.template.ui.hello.RainbowColorChangeText
import dzmitryk.app.template.ui.hello.RainbowColorText
import dzmitryk.app.template.ui.theme.AppTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val text = "Hello World!!"
        setContent {
            AppTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                Greeting(text = text)
                            }
                        }
                        item {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                RainbowColorChangeText(text = text)
                            }
                        }
                        item {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                RainbowColorText(text = text)
                            }
                        }
                    }

                }
            }
        }
    }
}

