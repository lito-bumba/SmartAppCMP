import ComposeApp
import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            VStack{
                ComposeView()
                    .ignoresSafeArea()
            }
        }
    }
}

struct ComposeView: UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(
            nativeViewFactory: iOSNativeViewFactory.shared
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
