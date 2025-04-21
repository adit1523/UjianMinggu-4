# Cucumber-Project-Saucedemo

# Deskripsi
Project ini adalah Automated testing untuk website Saucedemo.com dengan menggunakan Selenium dan Cucumber
dengan pendekatan Behavior-Driven Development(BDD)

# Cara Menjalankan
## 1. Clone Repository
https://github.com/adit1523/UjianMinggu-4
## 2. Masuk Ke Folder Project
cd UjianMinggu-4
 ## 3. Build Project dan Jalankan Test
  * mvn clean install
  * mvn test

# Scenario Gherkin
# Feature: Login

  ## Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    Then I should be redirected to dashboard page

  ## Scenario: Invalid login with invalid credentials
    Given I am logout
    When I enter a invalid username and password
    And I click the login button
    Then I see message invalid credentials
    
 # Feature: Inventory

 ## Scenario: Add product and checkout
    Given I am login swag labs
    When I click login
    And I click product and checkout
    And I fill form checkout
    Then I see message thank you for your order
    Given I go to logout

 ## Scenario: Invalid fill form checkout
    When I go to checkout
    And I am not input form checkout
    Then I see message first name is required
    Given I am logout after see message invalid

# Tools yang digunakan
- Java JDK 17
- Maven
- Selenium WebDriver
- Cucumber (Gherkin syntax)
- TestNG

# Skenario yang di uji
 ## Login Valid
 Menguji login dengan memasukan username dan password yang valid.
 ## Login Invalid
 Menguji login dengan memasukan username dan password yang invalid.
 ## Checkout Success
 Menguji fitur add product, checkout dan mengisi form dengan benar sampai success checkout.
 ## Checkout Failed
 Menguji fitur add product, checkout dan tidak mengisi form untuk checkout.

# Link
Spreadsheet Scenario: https://docs.google.com/spreadsheets/d/1fMldpN2MnmXMNcR3pc-5LHv9hZMGey61zFuWgJnqfaY/edit?usp=sharing







    
