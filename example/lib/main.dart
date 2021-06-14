import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_scroball/flutter_scroball.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _listenState = 'Not Listening';

  @override
  void initState() {
    super.initState();
    startListening();
  }

  Future<void> startListening() async {
    try {
      _listenState =
          await FlutterScroball.startListening ?? 'Error when initialising';
    } on PlatformException {
      _listenState = 'Failed to get platform version.';
    }
    
    if (!mounted) return;

    setState(() {
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Scroball Plugin App'),
        ),
        body: Center(
          child: Text('Status: $_listenState\n'),
        ),
      ),
    );
  }
}
