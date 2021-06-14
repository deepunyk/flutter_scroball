package dev.dsi.flutter_scroball;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Scrobble {

  public abstract dev.dsi.flutter_scroball.Track track();

  public abstract int timestamp();

  public abstract ScrobbleStatus status();

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_Scrobble.Builder().status(new ScrobbleStatus(0));
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder track(dev.dsi.flutter_scroball.Track track);

    public abstract Builder timestamp(int timestamp);

    public abstract Builder status(ScrobbleStatus status);

    public abstract Scrobble build();
  }
}
