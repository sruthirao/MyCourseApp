Feature: User Service Integration Test
scenario: create a User
when client passes user object to service
Then the user object should be created with id set and returned to the service