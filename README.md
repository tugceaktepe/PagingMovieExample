# PagingMovieExample

PagingMovieExample is a simple movie list application. I'm using **TMDB** API as a source provides movies' data and images. Ref: https://developers.themoviedb.org/3

## Architecture

I'm trying to follow clean architecture principles and MVVM design pattern. The folder structure is as follows : 


### Data
Data package includes data model, paging data source and repository classes.

### UI
UI package includes Activity, Adapter and ViewModel classes.

### Util
Util package includes format function for decimal parts of popularity value of a movie.


## Technology

* Paging3 
* View Binding
* ViewModel
* Kotlin Flow, Coroutines

## TODOs and Improvements
* Fix of Performance Issues
* Maintenance using Clean Architecture Rules
* Dependency Injection 
* Additional Features
* UI Design
* Unit Tests
* Instrumentation Tests




