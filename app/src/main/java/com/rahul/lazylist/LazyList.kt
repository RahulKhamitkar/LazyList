package com.rahul.lazylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LazyListLayout() {
    val names = listOf<String>("Rahul", "Sachin", "Dhoni", "Kholi", "Rohit", "Pandya")
    val imageList = listOf<Int>(
        R.drawable.profile_image,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6
    )

    val gridImages = arrayListOf<Int>()
    for (i in 0..100) {
        gridImages.add(imageList.random())
    }


    Column {
        //List of images with Vertical grids scroll
        LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), modifier = Modifier.weight(1f)) {
            items(gridImages) {
                val painterRes = painterResource(id = it)
                Image(
                    painter = painterRes,
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
        }

        //List of Cricketer list and
        LazyColumn(modifier = Modifier.weight(1f)) {

            item { Text(text = "Top Cricketer List") }
            items(names) {
                Text(text = it)
            }
        }

        //List of images with Horizontal grids scroll
        LazyHorizontalGrid(rows = GridCells.Adaptive(100.dp), modifier = Modifier.weight(1f)) {
            items(gridImages) {
                val painterRes = painterResource(id = it)
                Image(
                    painter = painterRes,
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}