# OnBoardingKit

![Build Status](https://img.shields.io/github/actions/workflow/status/Aumaidkh/HopcapeMobileOnBoarding/main.yml?branch=main&label=Build&logo=github&style=for-the-badge)


![Maven Central](https://img.shields.io/maven-central/v/io.github.aumaidkh/onboarding-mobile)

## What is OnBoardingKit?

`OnBoardingKit` is a library designed to simplify the creation of onboarding experiences in your Android and iOS applications. It provides a set of pre-built UI components and utilities that allow you to quickly implement common onboarding flows, such as feature highlights, guided tours, and permission requests. The library is built with flexibility and customization in mind, allowing you to tailor the onboarding experience to your specific app's needs.

## How to Use the Library

### Kotlin (Android)

1.  **Add the dependency:**

    Add the following dependency to your module's `build.gradle.kts` file:

    ```
    dependencies {
        implementation("io.github.aumaidkh:onboarding-mobile:$version)
    }
    
    ```
2.  **Basic Usage:**

    Here's a basic example of how to use `OnBoardingKit` in your Android app:

```

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {

    private val onBoardingKit = OnBoardingKit.create(
        factory = AndroidOnBoardingDependencyFactory(this)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        
        setContent {
            onBoardingKit.configure(AndroidOnBoardingLauncher(this)) {
                addPages(
                    OnBoardingPage(
                        title = "Find and Book Doctors with Ease",
                        body = "Search for specialists near you, view their profiles, and book appointments in just a few taps. No waiting, no hassle.",
                        illustrationImage = com.hopcape.onboarding.R.drawable.undraw_love,
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )
                addPages(
                    OnBoardingPage(
                        title = "Order Medicines, Anytime",
                        body = "Shop for prescriptions and over-the-counter medicines from trusted pharmacies, and get them delivered to your doorstep.",
                        illustrationImage = com.hopcape.onboarding.R.drawable.undraw_love,
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )
                addPages(
                    OnBoardingPage(
                        title = "We're Here for You",
                        body = "Need help? Our support team is available around the clock to assist you with your healthcare needs.",
                        illustrationImage = com.hopcape.onboarding.R.drawable.undraw_love,
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )

                addTheme {
                    setPrimaryColor(Color(0XFF2893e1))
                    setSecondaryColor(Color(0XFFBEE2fD))
                    build()
                }
                build()
            }
            onBoardingKit.start(
                onComplete = {
                    // Navigate to destination here
                }
            )
        }
    }
}
```
In this example, `OnBoardingManager` is initialized with the activity context, and a list of `Step` objects is created. Each step defines the title, description, and the target view to highlight. The `start()` method then initiates the onboarding flow.

### Swift (iOS)

1.  **Add the dependency:**

    If you are using Swift Package Manager, add the library as a dependency in your `Package.swift` file:

2.  **Basic Usage:**

    Here's a basic example of how to use `OnBoardingKit` in your iOS app:

    ```
    struct SplashView: View {
    var body: some View {
        VStack{
            Text("Splash View")
                .onAppear{
                    if let rootWindow = UIApplication.shared.   windows.first {
                        let onBoardingLauncher = IOSOnBoardingLauncher(window: rootWindow)
                        let factory = IOSOnBoardingDependencyFactory()
                        let onBoardingKit: OnBoardingKit = OnBoardingKitCompanion().create(factory: factory)
                        let onBoardingConfig: (OnBoardingConfigBuilder) -> OnBoardingConfig = { builder in
                            let theme: (OnBoardingThemeBuilder) -> OnBoardingTheme = { themeBuilder in
                                themeBuilder.setPrimaryColorArgb(color: 0xFF2893E1)
                                return themeBuilder.build()
                            }
                            builder.addTheme(themeBuilder: theme)
                            if let imageUrl = Bundle.main.url(forResource: "undraw_love", withExtension: "svg") {
                                let page1 = OnBoardingPage(title: "Find and Book Doctors with Ease", textColor: 0, body: "Search for specialists near you, view their profiles, and book appointments in just a few taps. No waiting, no hassle.", bodyColor: 0, illustrationImage: "\(imageUrl)")
                                let page2 = OnBoardingPage(title: "Order Medicines, Anytime", textColor: 0, body: "Shop for prescriptions and over-the-counter medicines from trusted pharmacies, and get them delivered to your doorstep.", bodyColor: 0, illustrationImage: "\(imageUrl)")
                                let page3 = OnBoardingPage(title: "We're Here for You", textColor: 0, body: "Need help? Our support team is available around the clock to assist you with your healthcare needs.", bodyColor: 0, illustrationImage: "\(imageUrl)")
                                print("Image URL: \(imageUrl)")
                                let allPages = [page1]
                                let obBoardingPages = allPages
                                builder.addPages(pages: page1)
                                builder.addPages(pages: page2)
                                builder.addPages(pages: page3)
                            }

                            return builder.build()
                        }
                        onBoardingKit.configure(onBoardingLauncher: onBoardingLauncher,configBuilder: onBoardingConfig)
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
    ```

    In this example, `OnBoardingManager` is initialized with the view controller, and a list of `Step` objects is created. Each step defines the title, description, and the target view to highlight. The `start()` method then initiates the onboarding flow.

## Advantages of OnBoardingKit

*   **Simplified Onboarding:** Quickly implement onboarding flows without writing complex UI logic from scratch.
*   **Consistent User Experience:** Provides a consistent and intuitive onboarding experience across your app.
*   **Customizable:** Easily customize the appearance and behavior of the onboarding steps to match your app's design.
*   **Cross-Platform:** Supports both Android (Kotlin) and iOS (Swift) platforms, allowing you to reuse onboarding logic.
*   **Easy to Integrate:** Simple API and clear documentation make it easy to integrate the library into your existing projects.
*   **Improved User Engagement:** By guiding users through your app's features, you can increase user engagement and retention.

## Contributing

We welcome contributions to `OnBoardingKit`! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request on our [GitHub repository](your_repo_url).

## License

This project is licensed under the [Your License] License - see the [LICENSE.md](LICENSE.md) file for details.
