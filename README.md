# Anagram Kata

Java Maven application solving CodeKata sixth Kata : Anagrams

## Potential upgrades

`AnagramService` could be a lot better! We could : 
- Saving word list into a `WordRepository` at application start and getting word list from the repository could allow us faster anagram detection

Other than that : 
- `mvn test` does not execute tests. It's probably a bad Maven configuration. Tests can be run with an IDE though.
- Dependency injection could be handled by hk2 or something else.

## Installation

Maven is used as a build automation tool, as well as a dependency manager. To build the application, use : 

```
mvn clean install
```

## Usage

### Execute app

To execute the application, use : 

```
mvn exec:java
```

The app will be running on [http://localhost:8080](http://localhost:8080).

## Contributing

### Run tests

Tests are located in `src/test/java/com/rocknprog/anagramkata`. They are all checked pre-commit and during the CI pipeline. Coverage report are generated using Jacoco during the report built phase.

To run unit tests, use :

```
mvn test
```

### Apply code style

Code style is verified at each commit. To apply [Google Java Code Style](https://google.github.io/styleguide/javaguide.html) throughout the source code, use : 

```
mvn git-code-format:format-code
```

To simply check code style, use :

```
mvn git-code-format:validate-code-format
```

## License

`CC BY-NC-SA 4.0` : [Attribution-NonCommercial-ShareAlike 4.0 International](LICENSE.md), copied from [Jan T. Sott's Creative Commons Markdown repository](https://github.com/idleberg/Creative-Commons-Markdown).
