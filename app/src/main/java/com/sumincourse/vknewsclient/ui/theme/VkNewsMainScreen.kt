package com.sumincourse.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sumin.vknewsclient.ui.theme.PostCard
import com.sumincourse.vknewsclient.MainViewModel
import com.sumincourse.vknewsclient.domain.FeedPost
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val selectedNavItem by viewModel.selectedNavItem.observeAsState(NavigationItem.Home)


    val feedPost = viewModel.feedPosts.observeAsState(FeedPost())

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember {
        mutableStateOf(true)
    }

    Scaffold(
        floatingActionButton = {
            if (fabIsVisible.value) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackbarHostState.showSnackbar(
                                message = "Snackbar message",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )
                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisible.value = false
                            }
                        }
                    }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {
            BottomNavigation {


                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = selectedNavItem==item,
                        onClick = { viewModel.selectNavItem(item) },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) {

        when(selectedNavItem){
            NavigationItem.Home -> {
                HomeScreen(viewModel = viewModel, paddingValues = it)
            }

            NavigationItem.Favourite -> TextCounter(name = "Favourite")
            NavigationItem.Profile -> TextCounter(name = "Profile")
        }

    }
}

@Composable
private fun TextCounter(name: String) {
    var count by remember {
        mutableStateOf(0)
    }

    Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count",
        color = Color.Black
    )
}