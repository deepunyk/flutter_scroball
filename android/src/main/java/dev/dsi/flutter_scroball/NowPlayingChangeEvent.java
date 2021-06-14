package dev.dsi.flutter_scroball;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NowPlayingChangeEvent {

  public abstract dev.dsi.flutter_scroball.Track track();

  public abstract String source();

  public static Builder builder() {
    return new AutoValue_NowPlayingChangeEvent.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder track(dev.dsi.flutter_scroball.Track track);

    public abstract Builder source(String source);

    public abstract NowPlayingChangeEvent build();
  }
}
