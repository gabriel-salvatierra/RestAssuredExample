@Books
Feature: In this feature a Book will be created given a JSON file, then deleted

  Scenario Outline:
    Given A new book "<bookName>" is created
    When I get its ID
    Then The new book is deleted
    Examples:
      | bookName                         |
      | Learn Appium Automation with Java |