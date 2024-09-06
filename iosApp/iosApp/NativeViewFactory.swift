//
//  NativeViewFactory.swift
//  iosApp
//
//  Created by Cazombo Bumba on 06/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import ComposeApp
import UIKit
import SwiftUI

class iOSNativeViewFactory : NativeViewFactory {
    
    static var shared = iOSNativeViewFactory()
    
    func createWebView(url: String) -> UIViewController {
        let webView = WebViewKit(url: url)
        return UIHostingController(rootView: webView)
    }
}
