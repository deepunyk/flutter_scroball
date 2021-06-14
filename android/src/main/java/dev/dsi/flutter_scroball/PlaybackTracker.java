package dev.dsi.flutter_scroball;

import android.media.MediaMetadata;
import android.media.session.PlaybackState;

import dev.dsi.flutter_scroball.transforms.MetadataTransformers;

import java.util.HashMap;
import java.util.Map;

public class PlaybackTracker {

  private final ScrobbleNotificationManager scrobbleNotificationManager;
  private final dev.dsi.flutter_scroball.Scrobbler scrobbler;
  private final MetadataTransformers metadataTransformers = new MetadataTransformers();
  private Map<String, dev.dsi.flutter_scroball.PlayerState> playerStates = new HashMap<>();

  public PlaybackTracker(
      ScrobbleNotificationManager scrobbleNotificationManager, dev.dsi.flutter_scroball.Scrobbler scrobbler) {
    this.scrobbleNotificationManager = scrobbleNotificationManager;
    this.scrobbler = scrobbler;
  }

  public void handlePlaybackStateChange(String player, PlaybackState playbackState) {
    if (playbackState == null) {
      return;
    }

    dev.dsi.flutter_scroball.PlayerState playerState = getOrCreatePlayerState(player);
    playerState.setPlaybackState(playbackState);
  }

  public void handleMetadataChange(String player, MediaMetadata metadata) {
    if (metadata == null) {
      return;
    }

    dev.dsi.flutter_scroball.Track track =
        metadataTransformers.transformForPackageName(player, dev.dsi.flutter_scroball.Track.fromMediaMetadata(metadata));

    if (!track.isValid()) {
      return;
    }

    dev.dsi.flutter_scroball.PlayerState playerState = getOrCreatePlayerState(player);
    playerState.setTrack(track);
  }

  public void handleSessionTermination(String player) {
    dev.dsi.flutter_scroball.PlayerState playerState = getOrCreatePlayerState(player);
    PlaybackState playbackState =
        new PlaybackState.Builder()
            .setState(PlaybackState.STATE_PAUSED, PlaybackState.PLAYBACK_POSITION_UNKNOWN, 1)
            .build();
    playerState.setPlaybackState(playbackState);
  }

  private dev.dsi.flutter_scroball.PlayerState getOrCreatePlayerState(String player) {
    dev.dsi.flutter_scroball.PlayerState playerState = playerStates.get(player);

    if (!playerStates.containsKey(player)) {
      playerState = new dev.dsi.flutter_scroball.PlayerState(player, scrobbler, scrobbleNotificationManager);
      playerStates.put(player, playerState);
    }

    return playerState;
  }
}
