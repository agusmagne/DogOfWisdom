# DogOfWisdom

This application consists of two screens only.
The first one displays a list of different dog breeds and its variations.
When selecting one dog breed, you're presented with a new screen.
This new screen contains 10 random pictures of such breed.

## Regarding dependencies

- Dagger-Hilt:2.37 for handling dependency injection along with AndroidX-Fragment-KTX:1.3.6 to help inject ViewModels

- Retrofit 2.9.0 for HTTP calls, along with GSON from Google and the GSON Converter from Retrofit

- Glide for basic image loading

## Architecture and structure
#### Architecture
The architecture is basic MVVM with what I call a 'centralized' event system.
Event and VoidEvent classes are implemented which are object wrappers basically.
They contain a boolean specifying if the LiveData has been observed already.
If it has been observed, all following observations will be ignored, until the value is changed.

ViewModels inherit a method called 'safeCall' which allows them to execute coroutines safely and make use of suspend functions quicker, catching exceptions in a centralized manner

#### Structure
The app is structured in five folders.
- DAGGER: Dependency injection modules. Given the simplicity of the application, all provide singleton objects, but are in separate files because of different purpose.
- MODEL: We have an Entities folder, which contains all objects we will use to display the user some information, no raw data. The Service, Requests and Responses folder are self explainatory.
- NETWORK: Interfaces containing different HTTP calls
- VIEW: Contains all view logic, and also all ViewModel logic. One would think that ViewModels, as they're closer to data than Activities/Fragments, should be on a different folder such as ViewModel. But from experience I find that having the ViewModel of an Activity/Fragment inside the same folder is very comfortable, given that when you're modifying a view you'll most likely modify the ViewModel related to such view.
- UTILS: All utils. Currently only hosts an Entity Mapper, which maps raw data from http calls to entities.

I didn't take much time to work on the interface, hence it looks basic. Personally, architecture and structure are more important things, specially when working on the foundations of an application. My most proud work regarding user interface and design can be found in here: https://youtu.be/llLyX5L2YGw

## No unit tests were done on this app.
