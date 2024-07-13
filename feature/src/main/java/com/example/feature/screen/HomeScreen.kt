package com.example.feature.screen

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.feature.R
import com.example.feature.component.TitleTopBar
import com.example.feature.component.TodoListItem
import com.example.feature.model.Task
import com.example.feature.navigation.NavigationDrawerContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(onCreateTaskClicked: () -> Unit) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerContent()
            }
        },
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .padding(top = 40.dp),
            floatingActionButton = {
                FloatingActionButton(
                    shape = CircleShape,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                onCreateTaskClicked()
                            }
                        }
                    }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "")
                }
            }
        ) { _ ->
            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TitleTopBar(icon = R.drawable.baseline_menu_24, title = "All Tasks") {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
                SearchBar(
                    query = "Search",
                    onQueryChange = {

                    },
                    onSearch = {

                    },
                    active = false,
                    onActiveChange = {
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    //TODO list de résult
                }
                val fakeList = listOf(
                    Task("task", "today", false),
                    Task("task", "today 2 ", false),
                    Task("task", "today 3 =", false),
                    Task("task", "today4 ", false),
                    Task("task", "today5", false)
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                ) {
                    fakeList.forEach {
                        stickyHeader {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.White)
                                    .padding(vertical = 4.dp),
                                text = it.dateToDone,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                        items(5) {
                            TodoListItem()
                        }
                    }
                }

            }
        }
    }
}