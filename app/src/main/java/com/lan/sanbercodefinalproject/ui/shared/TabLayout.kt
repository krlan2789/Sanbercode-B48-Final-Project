package com.lan.sanbercodefinalproject.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lan.sanbercodefinalproject.activity.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.TabLayoutViewModel

@Composable
fun TabLayout(viewModel: TabLayoutViewModel, layout: (@Composable (String) -> Unit)? = null) {
    val tabIndex = viewModel.tabIndex.observeAsState(0)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        ScrollableTabRow(
            selectedTabIndex = tabIndex.value,
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.primaryContainer,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex.value])
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    color = MaterialTheme.colorScheme.primaryContainer
                )
            }
        ) {
            viewModel.tabs.forEachIndexed { index, kvp ->
                Tab(
                    text = { Text(text = kvp.second) },
                    modifier = Modifier.background(
                        if (tabIndex.value == index) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.primary
                    ),
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.primaryContainer,
                    selected = tabIndex.value == index,
                    onClick = { viewModel.updateTabIndex(index) }
                )
            }
        }

        if (layout != null) {
            layout(viewModel.tabs[tabIndex.value].first)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        TabLayout(TabLayoutViewModel())
    }
}
