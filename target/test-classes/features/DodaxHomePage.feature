@HomePage @NotLoggedUser
Feature: Home Page Feature

  @GoToHomePage
  Scenario: Home Page - Go To Home Page
    Given The user is on home page of his domain
    Then The reached domain is the right one

  @HomePageCheckCookies
  Scenario: Home Page - Check cookies
   Given The user is on home page of his domain
   When The user clicks the link Privacy policy
   Then The page for privacy policy loads
   When The user clicks on the button Cookies accept
   Then The cookies are set

   @HomePageCheckSearchBar
   Scenario Outline: Home page - Check Search Bar - <to_search>
   Given The user is on home page of his domain
   When The user type anything "<to_search>" in the search bar
   Then Products with categories are autocompleted
   When The user submit the search with "<to_search>" string
   Then The result page for "<to_search>" is shown

    Examples:
      | to_search |
      | music     |
      | book      |

 @HomePageSearchUnavailableProductName
Scenario Outline: Home Page - Search Unavailable Product Name - <product_name>
  Given The user is on home page of his domain
  When Search bar is displayed on the screen
  And The user type unavailable product "<product_name>" in the search bar and submit the search
  Then The empty page with Back button, carousel with additional products at the bottom is displayed
  When The user clicks on the Back button
  Then The Home page loads
  
   Examples:
      | product_name |
      | kkpttt       |

  @HomePageCheckLinksInFooter
  Scenario Outline: Home Page - Check Footer Link - <link>
    Given The user is on home page of his domain
    And The user accepts cookies
    When The user clicks on the footer link "<link>"
    Then The right page for the used footer link "<link>" is loaded

    Examples:
      | link   |
      | faq    |
      | privacy|
      | safety |
      | terms  |
      | about  |
      | jobs   |
      | imprint|
#
#  # it is a specific test for Dodax
#  # the test will be ignored until the real migration done (as links now navigate to the old test env adn on Lambdatest we get Error 403)
#  @HomePageChangeDomain @Dodax @Ignore
#  Scenario Outline: Home Page - Change domain to <domain>
#    Given The user is on home page of his domain
#    And The user accepts cookies
#    When The user clicks on the link for "<domain>"
#    Then The user should be redirected to the right domain
#
#    Examples:
#      | domain|
#      |gb|
#      |it|
#      |fr|
#      |pl|
#      |nl|
#      |us|
#      |es|
#      |de|
#      |at|
#      |ch|
#      |jp|