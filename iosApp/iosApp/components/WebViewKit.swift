//
//  WebView.swift
//  iosApp
//
//  Created by Cazombo Bumba on 25/08/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import WebKit

struct WebView: View {
    var body: some View {
        WebViewKit()
            .background(.green)
    }
}

func webViewFactory() -> UIViewController {
    let webView = WebView()
    return UIHostingController(rootView: webView)
}

struct WebViewKit: UIViewRepresentable {
    
    let webView: WKWebView
    
    init() {
        self.webView = WKWebView()
        loadURL()
    }
    
    func makeUIView(context: Context) -> WKWebView {
        webView.allowsBackForwardNavigationGestures = true
        return webView
    }
    
    func updateUIView(_ uiView: WKWebView, context: Context) {
        
    }
    
    func loadURL() {
        webView.load(URLRequest(url: URL(string: "https://www.google.com")!))
    }
}


#Preview {
    WebView()
}
