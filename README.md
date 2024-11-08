# News API Client

This is a News API Client built using Kotlin and Jetpack libraries for fetching and displaying the latest news from various sources. The app allows users to search for news articles, view detailed information about each article, and save articles for later. The app supports pagination and includes a search feature to filter news by keywords.

## Features

- Display a list of news articles fetched from the News API.  
- Search for news articles by keyword.  
- Pagination support for fetching more articles when the user scrolls to the bottom.  
- View detailed information of selected articles.  
- Save articles to a local database.  
- Delete saved articles with an option to undo.  
- Handle network errors and loading states.  

## Tech Stack

- Kotlin  
- Jetpack Libraries:  
  - LiveData  
  - ViewModel  
  - Navigation  
  - RecyclerView  
  - ViewBinding  
- Dagger-Hilt for Dependency Injection  
- Retrofit for API calls  
- News API for fetching the latest news  
- Coroutines for handling asynchronous tasks  
- Material Design for UI components  
- Room Database for saving articles locally  
  

## Key Features

- **Pagination**: The app automatically loads more news articles as you scroll down.  
- **Search Functionality**: Allows users to search news articles based on keywords.  
- **Save Articles**: Users can save articles to view them later in the saved section.  
- **Delete and Undo Save**: Users can delete saved articles with an option to undo.  
- **Error Handling**: Displays error messages in case of network failure.  


## Acknowledgments

- NewsAPI for providing free access to news data.  
- Jetpack Libraries for simplifying Android development.  
- Room Database for local data storage.  
- Udemy for the helpful resources used in learning the technologies behind this project.  
