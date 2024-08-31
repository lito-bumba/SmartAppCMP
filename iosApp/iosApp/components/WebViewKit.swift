//
//  WebView.swift
//  iosApp
//
//  Created by Cazombo Bumba on 25/08/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import WebKit

struct WebViewKit: View {
    let url: String
    
    var body: some View {
        IOSWebView(url: self.url)
    }
}

struct IOSWebView: UIViewRepresentable {
    
    private let webView: WKWebView
    private let urlStr: String
    
    
    init(url: String) {
        self.webView = WKWebView()
        self.urlStr = url
        self.loadURL()
    }
    
    func makeUIView(context: Context) -> WKWebView {
        webView.allowsBackForwardNavigationGestures = true
        return webView
    }
    
    func updateUIView(_ uiView: WKWebView, context: Context) {}
    
    func loadURL() {
        webView.load(URLRequest(url: URL(string: urlStr)!))
    }
}


#Preview {
    WebViewKit(url: "https://www.google.com")
}
