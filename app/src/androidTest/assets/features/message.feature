Feature: can show message dialog

Scenario:
    When I enter message "Hello, World!"
    Then I click button with text "Show message"
    Then I see dialog with message "Hello, World!"