# PagingMovieExample

PagingMovieExample is a simple movie list application. I'm using **TMDB** API as a source provides movies' data and images. Ref: https://developers.themoviedb.org/3

## Architecture

I'm trying to follow clean architecture principles and MVVM design pattern. The folder structure is as follows : 


### data
Data package includes data model, paging data source and repository classes.

### di
DI package includes dependency injections provided via Hilt.

### ui
UI package includes Activity, Adapter and ViewModel classes.

### util
Util package includes utility classes.


## Technology

* Paging3 
* View Binding
* ViewModel
* Kotlin Flow, Coroutines
* Hilt
* MockWebServer
* Espresso
