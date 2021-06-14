package dev.dsi.flutter_scroball;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.common.eventbus.EventBus;

public class LoveTrackService extends IntentService {

  public static String TRACK_KEY = "love-data-track";
  public static String ARTIST_KEY = "love-data-artist";

  public LoveTrackService() {
    super("LoveTrackService");
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onHandleIntent(Intent intent) {
    dev.dsi.flutter_scroball.Track track =
        dev.dsi.flutter_scroball.Track.builder()
            .track(intent.getStringExtra(TRACK_KEY))
            .artist(intent.getStringExtra(ARTIST_KEY))
            .build();

    EventBus eventBus = dev.dsi.flutter_scroball.ScroballApplication.getEventBus();
    eventBus.post(dev.dsi.flutter_scroball.TrackLoveEvent.create(track));
  }
}
