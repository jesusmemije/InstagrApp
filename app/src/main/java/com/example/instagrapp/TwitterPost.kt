package com.example.instagrapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagrapp.ui.theme.InstagrAppTheme

@Composable
fun TwitterPost(name: String, username: String, schedule: String, post: String) {
    Column {
        Row(modifier = Modifier.padding(16.dp)) {
            IconAvatar()
            Spacer(modifier = Modifier.size((16.dp)))
            Column {
                HeadPost(name, username, schedule)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = post)
                Spacer(modifier = Modifier.size(8.dp))
                Image(
                    painterResource(id = R.drawable.profile),
                    contentDescription = "Image Post",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                )
                ButtonActions()
            }
        }
        Divider()
    }
}

@Composable
fun ButtonActions() {

    var chat by remember { mutableStateOf(false) }
    var retweet by remember { mutableStateOf(false) }
    var favorite by remember { mutableStateOf(false) }

    Row(Modifier.padding(16.dp)) {
        SocialIcon(modifier = Modifier.weight(1f), unselectedIcon = {
            Icon(
                painterResource(id = R.drawable.ic_chat),
                contentDescription = "Comment",
                tint = Color(0xFF7E8B98)
            )
        }, selectedIcon = {
            Icon(
                painterResource(id = R.drawable.ic_chat_filled),
                contentDescription = "Comment",
                tint = Color(0xFF7E8B98)
            )
        }, isSelected = chat
        ) {
            chat = !chat
        }

        SocialIcon(modifier = Modifier.weight(1f), unselectedIcon = {
            Icon(
                painterResource(id = R.drawable.ic_rt),
                contentDescription = "Comment",
                tint = Color(0xFF7E8B98)
            )
        }, selectedIcon = {
            Icon(
                painterResource(id = R.drawable.ic_rt),
                contentDescription = "Comment",
                tint = Color(0xFF00BA7C)
            )
        }, isSelected = retweet
        ) {
            retweet = !retweet
        }

        SocialIcon(modifier = Modifier.weight(1f), unselectedIcon = {
            Icon(
                painterResource(id = R.drawable.ic_like),
                contentDescription = "Comment",
                tint = Color(0xFF7E8B98)
            )
        }, selectedIcon = {
            Icon(
                painterResource(id = R.drawable.ic_like_filled),
                contentDescription = "Comment",
                tint = Color(0xFFF91880)
            )
        }, isSelected = favorite
        ) {
            favorite = !favorite
        }
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun HeadPost(name: String, username: String, schedule: String) {
    Row {
        Text(text = name, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size((4.dp)))
        Text(text = username, color = Color.Gray)
        Spacer(modifier = Modifier.size((4.dp)))
        Text(text = schedule, color = Color.Gray)
        Spacer(modifier = Modifier.weight(1f))
        Icon(painterResource(R.drawable.ic_dots), contentDescription = "opctions")
    }
}

@Composable
fun IconAvatar() {
    Image(
        painterResource(id = R.drawable.profile),
        contentDescription = "Avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(42.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstagrAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            TwitterPost(
                name = "Jesús",
                username = "@JesusMemije",
                schedule = "3H",
                post = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta)"
            )
        }
    }
}