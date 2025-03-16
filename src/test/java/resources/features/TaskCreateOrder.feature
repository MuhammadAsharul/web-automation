# Feature: Purchase the order from ecommerce

# Background: Buyer landed to website
#     Given Buyer landing to ecommerce
# Scenario Outline: Create Order Positive Case
#     Given Buyer logged to website username <user-name> and password <password>
#     When Buyer add <product_name> to cart
#     And Buyer checkout <product_name>
#     And Buyer input firstname <first-name> and lastname <last-name> and postal-code <postal-code>
#     And Buyer finish order <product_name>
#     Then Buyer will see message is displayed on complete page Thank you for your order!

#     Examples: 
#     | user-name      | password     | product_name         | first-name | last-name | postal-code |
#     | standard_user | secret_sauce | Sauce Labs Backpack  | Albert     | Einstein  |12345        |


Feature: SauceDemo Negative Testing

Background: Buyer landed to website
    Given Buyer landing to ecommercee

Scenario Outline: Buyer fails to complete the purchase due to missing or invalid details
    Given Buyer logs in to SauceDemo using username <username> and password <password>
    When Buyer adds <product_name> to the cart, goes to the cart page
    And Buyer proceeds to checkout <product_name>
    And Buyer enters shipping details: <first_name>, <last_name>, <postal_code>
    Then Buyer sees an error message <error_message>

Examples:
    | username           | password     | product_name             | first_name | last_name | postal_code | error_message                         |
    | standard_user      | secret_sauce | Sauce Labs Backpack      |            | Doe       | 12345       | Error: First Name is required         |