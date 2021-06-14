
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterScroball {
  static const MethodChannel _channel =
      const MethodChannel('flutter_scroball');

  static Future<String?> get startListening async {
    final String? version = await _channel.invokeMethod('startListening');
    return version;
  }
}
