# Selenium Google Maps Search

### Implemented in Java, using Selenium and TestNG

 - Navigate to https://www.google.com/maps and accept cookies if the button shows up
 - Search for Dublin using search box
 - Wait for results to render on the screen
 - Validate page title, sidebar header text for location and url with location as query parameter
 - Click on directions button and validates existence of destination in destination input

### Dependencies

 - Chromedriver, to be copied to resources folder
 - I used IntelliJ CE to run the tests but the same can be done through cli provided maven is installed through mvn test 