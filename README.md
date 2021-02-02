# Anagram Kata

Java Maven application solving [CodeKata's sixth Kata : Anagrams](http://codekata.com/kata/kata06-anagrams/)

## Potential upgrades

- Saving word list into a `WordRepository` at application start and getting word list from the repository could allow us faster anagram detection
- Dependency injection could be handled by hk2 or something else.

## Installation

Maven is used as a build automation tool, as well as a dependency manager. To build the application, use : 

```shell
mvn clean install
```

## Usage

### Execute app

To execute the application, use : 

```shell
mvn exec:java
```

The app will be running on [http://localhost:8080](http://localhost:8080).

To test, send the following to `POST /anagrams` : 
```json
{
  "word": "yourWord"
}
```

You will received anagrams in the following format : 
```json
{
  "anagrams": [
    "firstAnagram",
    "secondAnagram",
    ...
  ]
}
```

A Postman collection with the needed request can be found at [`resources/postman_collection.json`](resources/postman_collection.json)

## Contributing

### Run tests

Tests are located in `src/test/java/com/rocknprog/anagramkata`. They are all checked pre-commit and during the CI pipeline. Coverage report are generated using Jacoco during the report built phase.

To run unit tests, use :

```shell
mvn test
```

### Apply code style

Code style is verified at each commit. To apply [Google Java Code Style](https://google.github.io/styleguide/javaguide.html) throughout the source code, use : 

```shell
mvn git-code-format:format-code
```

To simply check code style, use :

```shell
mvn git-code-format:validate-code-format
```

## License

`CC BY-NC-SA 4.0` : [Attribution-NonCommercial-ShareAlike 4.0 International](LICENSE.md), copied from [Jan T. Sott's Creative Commons Markdown repository](https://github.com/idleberg/Creative-Commons-Markdown).
