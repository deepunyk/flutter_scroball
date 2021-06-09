#import "FlutterScroballPlugin.h"
#if __has_include(<flutter_scroball/flutter_scroball-Swift.h>)
#import <flutter_scroball/flutter_scroball-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_scroball-Swift.h"
#endif

@implementation FlutterScroballPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterScroballPlugin registerWithRegistrar:registrar];
}
@end
