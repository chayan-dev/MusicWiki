# MusicWiki

### Walktrough video: [VIDEO](https://drive.google.com/file/d/1TVB2UVJCNfSBZgF1vLrbkdes4Df2AGJy/view?usp=share_link)
### ScreenShots: 
![ss1](https://user-images.githubusercontent.com/50614321/217734868-854980fc-0735-42ce-9bda-c0622b635394.jpg)
![ss2](https://user-images.githubusercontent.com/50614321/217734906-f49d6475-7388-42c8-9b34-ca812e8b6c42.jpg)
![ss3](https://user-images.githubusercontent.com/50614321/217734923-448ee386-efca-476e-a44e-7e072b6a48c0.jpg)

## Tech used 👨‍💻 :

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development. Our app is totally written in kotlin.
- [Different Layouts](https://developer.android.com/guide/topics/ui/declaring-layout) -  In this app we have used difrenet layouts to make the app UI responsive. The used layouts are LinearLayout, ConstraintLayout.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more. Speacially used at the time of networking calls and using database .
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. Highly used shared viewmodel in the app.
  - [Navigation](https://developer.android.com/guide/navigation#:~:text=Navigation%20refers%20to%20the%20interactions,bars%20and%20the%20navigation%20drawer.) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. In our app we followed single app architecture using navigation and also implemented an unique nav nav drawer.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. 
- [Retrofit](https://github.com/square/retrofit) - A type-safe HTTP client for Android and Java.
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview?authuser=2) - RecyclerView makes it easy to efficiently display large sets of data. To show large lists.
- [MVVM](https://developer.android.com/jetpack/guide) - MVVM architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component. In the note taking section we used MVVM.
