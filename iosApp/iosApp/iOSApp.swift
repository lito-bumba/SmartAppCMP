import ComposeApp
import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            ComposeView()
                .ignoresSafeArea(.keyboard)
        }
    }
}

struct ComposeView: UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(
            webViewFactory: { url in
                webViewFactory(url: url)
            }
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    private func webViewFactory(url: String) -> UIViewController {
        let webViewKit = WebViewKit(url: url)
        return UIHostingController(rootView: webViewKit)
    }
}
