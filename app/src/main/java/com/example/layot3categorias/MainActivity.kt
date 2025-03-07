package com.example.layot3categorias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Layout3()
        }
    }
}

@Composable
fun Layout3() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Barra superior
        //TopAppBar(title = { Text("Categories")})

        // Grid de categorias
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            GridItemRow(listOf("Woman", "Man"))
            GridItemRow(listOf("Baby", "Travel"))
            GridItemRow(listOf("Tech", "Food & Drink"))
        }
    }
}

@Composable
fun GridItemRow(items: List<String>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (item in items) {
            CategoryCard(label = item, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun CategoryCard(label: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF527F80)),
        modifier = modifier
            //.padding(4.dp)
            .height(300.dp)
            .clickable { /* Ação ao clicar */ }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = label, color = Color.White, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoriesScreen() {
    Layout3()
}