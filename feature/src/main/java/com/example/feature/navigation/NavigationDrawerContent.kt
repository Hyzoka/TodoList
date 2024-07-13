package com.example.feature.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feature.R
import com.example.feature.model.NavigationMenuItem


@Composable
fun NavigationDrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .navigationBarsPadding()
    ) {
        ProfileComponent(
            drawable = R.drawable.baseline_person_outline_24,
            name = "Lea Michelle",
            email = "leamich@gmaiol.com"
        )

        Spacer(modifier = Modifier.size(32.dp))

        listOf(
            NavigationMenuItem.ALL_TASKS,
            NavigationMenuItem.TODAY_TASKS,
            NavigationMenuItem.SCHEDULED_TASKS,
            NavigationMenuItem.IMPORTANT_TASK,
            NavigationMenuItem.COMPLETED_TASK,
            NavigationMenuItem.DELETED_TASK,
        ).forEach { item ->
            NavigationDrawerItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = null)
                },
                label = {
                    Text(text = item.nameItem, style = MaterialTheme.typography.bodyLarge)

                },
                selected = item.isCurrentMenu,
                onClick = {

                }
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        NavigationDrawerItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_logout_24),
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Log Out", style = MaterialTheme.typography.bodyLarge)

            },
            selected = false,
            onClick = {
//TODO Log out
            }
        )
    }
}

@Composable
private fun ProfileComponent(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int, name: String, email: String
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier.padding(horizontal = 8.dp), verticalArrangement = Arrangement.Center
        ) {
            Text(text = name, style = MaterialTheme.typography.bodyMedium)
            Text(text = email, style = MaterialTheme.typography.bodySmall)

        }
    }
}

@Preview
@Composable
fun ProfileComponentPreview() {
    ProfileComponent(
        drawable = R.drawable.baseline_person_outline_24,
        name = "Moniqua",
        email = "moniqua@gmail.com"
    )
}