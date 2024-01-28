# Java + Selenium

### Preconditions : 
* to be able to run tests in all three browsers, verify browsers installed in yours PC
* tests were written on macOS, drivers were installed for this os (there were no requirement to make automation 
cross-platformed)

### MVN command to run:
Type from command line for running tests in different browsers with specific size:

* Safari - fullscreen size
* Chrome - 1024 x 768
* Firefox - 800 x 600

```
mvn clean test -P chrome
mvn clean test -P firefox
mvn clean test -P safari
```
