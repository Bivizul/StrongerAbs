package com.bivizul.strongerabs.presentation.ui

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPlayerCmp(
    url: String,
) {
    val context = LocalContext.current
    var playWhenReady = remember { mutableStateOf(true) }

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(url))
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            playWhenReady = playWhenReady
            prepare()
            play()
        }
    }

    DisposableEffect(
        AndroidView(
            factory = { context ->
                StyledPlayerView(context).apply {
                    player = exoPlayer
                    useController = false
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            })
    ) {
        onDispose {
            exoPlayer.release()
        }
    }
}