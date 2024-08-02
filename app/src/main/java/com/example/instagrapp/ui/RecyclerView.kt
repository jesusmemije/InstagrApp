package com.example.instagrapp.ui

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagrapp.R

@Composable
fun FrontRecyclerView() {
    val myList = listOf("Nao", "Sam", "Jesús")
    LazyColumn {
        item { Text(text = "Init") }
        items(myList) {
            Text(text = "Hola, $it")
        }
        item { Text(text = "End") }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(getSuperHeroes()) { superHero ->
            ItemHero(superHero = superHero) { superHero ->
                Toast.makeText(context, "Hola soy ${superHero.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superheros = getSuperHeroes().groupBy { it.publisher }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
    ) {
        superheros.forEach { (publisher, heroList) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                        .padding(8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            items(heroList) { superHero ->
                ItemHero(superHero = superHero) { superHero ->
                    Toast.makeText(context, "Hola soy ${superHero.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(getSuperHeroes()) { superHero ->
                ItemHero(superHero = superHero) { hero ->
                    Toast.makeText(context, "Hola soy ${hero.name}", Toast.LENGTH_SHORT).show()
                }
            }
        },
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
    )
}

@Composable
fun ItemHero(superHero: SuperHero, onClickItem: (SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onClickItem(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "Hero",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.name, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marbel", R.drawable.spiderman),
        SuperHero("Worverine", "Marbel", "DC", R.drawable.batman),
        SuperHero("Batman", "Parker", "Marbel", R.drawable.flash),
        SuperHero("Flash", "Glosh Go", "DC", R.drawable.green_lantern),
        SuperHero("Green", "Andromade", "Marbel", R.drawable.daredevil),
        SuperHero("Spiderman", "Petter Parker", "Marbel", R.drawable.spiderman),
        SuperHero("Worverine", "Marbel", "DC", R.drawable.batman),
        SuperHero("Batman", "Parker", "Marbel", R.drawable.flash),
        SuperHero("Flash", "Glosh Go", "DC", R.drawable.green_lantern),
        SuperHero("Green", "Andromade", "DC", R.drawable.daredevil),
    )
}

data class SuperHero(
    var name: String, var realName: String, val publisher: String, @DrawableRes var photo: Int
)