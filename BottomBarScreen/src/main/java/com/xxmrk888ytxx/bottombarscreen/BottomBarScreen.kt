package com.xxmrk888ytxx.bottombarscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.xxmrk888ytxx.bottombarscreen.models.BottomBarScreenModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarScreen(
    bottomBarScreens:ImmutableList<BottomBarScreenModel>,
    topBar:@Composable () -> Unit
) {
    val pager = rememberPagerState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar =  {
            topBar()
        },
        bottomBar = {
            Column(Modifier.fillMaxWidth()) {
                BottomBar(
                    bottomBarScreens = bottomBarScreens,
                    currentPage = pager.currentPage,
                    onScrollPage = {
                        scope.launch { pager.animateScrollToPage(it) }
                    })

            }
        }
    ) {
        HorizontalPager(
            pageCount = bottomBarScreens.size,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = pager
        ) { screen ->
            bottomBarScreens[screen].content()
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun BottomBar(
    bottomBarScreens:List<BottomBarScreenModel>,
    currentPage:Int,
    onScrollPage:(Int) -> Unit
) {
    NavigationBar {
        bottomBarScreens.forEachIndexed { index, bottomBarScreenModel ->
            NavigationBarItem(
                selected = index == currentPage,
                onClick = { onScrollPage(index) },
                icon = { Icon(
                    painter = painterResource(bottomBarScreenModel.icon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                ) },
                label = {
                    Text(text = bottomBarScreenModel.title)
                }
            )
        }
    }
}
