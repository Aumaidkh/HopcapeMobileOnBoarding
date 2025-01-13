//
//  SplashView.swift
//  OnBoardingTest
//
//  Created by Murtaza Khursheed on 10/01/25.
//

import SwiftUI
import onBoardingLibrary


struct SplashView: View {
    var body: some View {
        VStack{
            Text("Splash View")
                .onAppear{
                    if let rootWindow = UIApplication.shared.windows.first {
                        let onBoardingKit = OnBoardingKitImpl()
                        let onBoardingConfig: (OnBoardingConfigBuilder) -> OnBoardingConfig = { builder in
                            let theme: (OnBoardingThemeBuilder) -> OnBoardingTheme = { themeBuilder in
                                themeBuilder.setPrimaryColorArgb(color: 0xFF2893E1)
                                return themeBuilder.build()
                            }
                            builder.addTheme(themeBuilder: theme)
                            if let imageUrl = Bundle.main.url(forResource: "undraw_love", withExtension: "svg") {
                                let page1 = OnBoardingPage(title: "Find and Book Doctors with Ease", textColor: 0, body: "Search for specialists near you, view their profiles, and book appointments in just a few taps. No waiting, no hassle.", bodyColor: 0, illustrationUri: "\(imageUrl)")
                                let page2 = OnBoardingPage(title: "Order Medicines, Anytime", textColor: 0, body: "Shop for prescriptions and over-the-counter medicines from trusted pharmacies, and get them delivered to your doorstep.", bodyColor: 0, illustrationUri: "\(imageUrl)")
                                let page3 = OnBoardingPage(title: "We're Here for You", textColor: 0, body: "Need help? Our support team is available around the clock to assist you with your healthcare needs.", bodyColor: 0, illustrationUri: "\(imageUrl)")
                                print("Image URL: \(imageUrl)")
                                let allPages = [page1]
                                let obBoardingPages = allPages
                                builder.addPages(pages: page1)
                                builder.addPages(pages: page2)
                                builder.addPages(pages: page3)
                            }

                            return builder.build()
                        }
                        onBoardingKit.configure(context: rootWindow,configBuilder: onBoardingConfig)
                        onBoardingKit.start(
                            onComplete: onCompleteOnBoarding
                        )
                    }
                    
                }
                .safeAreaPadding()
                .padding()
                .background(.blue)
        }
    }
    
    func onCompleteOnBoarding() -> Void {
        
    }

}

