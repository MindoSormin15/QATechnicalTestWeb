Feature: SearchBook

  @Scenario002
  Scenario: Verify user is able to select option dropdown in Select Menu page
    Given User go to "https://demoqa.com/books"
    When User in "Book Store" page
    And User search book "qa engineer"
    Then User see "No rows found"

  @Scenario003
  Scenario: Verify User is able to search book and book detail is displayed correctly
    Given User go to "https://demoqa.com/books"
    When User in "Book Store" page
    And User search book "Git Pocket Guide"
    And User click book "Git Pocket Guide"
    Then User see "Git Pocket Guide" details
