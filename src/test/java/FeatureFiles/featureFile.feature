@tag
Feature: Wikipedia app tests

  @tag1
  Scenario: login test
    Given open wikipedia application
    And click on menu bar
    When click on login option
    And enter username and password
    And click login button
    Then again click on menubar
    And check text of username in menu bar
 
 
  @tag2
  Scenario: Title verification of searched article in landscape mode test
    Given open wikipedia application
    And search article
    Then verify the title in landscape mode
    
    @tag3
  Scenario: Title verification of searched article in landscape mode test
    Given open wikipedia application
    And search article
    Then validate top heading of page 
    
       @tag4
  Scenario: add bookmark page test
    Given open wikipedia application
    And search article
    And click on AddToReadingList
    And click on createList
    And press OK
    And verify the added page
         @tag5
  Scenario: add bookmark page test
    Given open wikipedia application
    And search article
    And click on myReadingList
    And click on removeArticle from list
    And verify the removing of article from myReadingList
    
 