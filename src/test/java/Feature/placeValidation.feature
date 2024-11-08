Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being successfully addedusing AddPlace API's
 Given Add Place Payload with "<name>" "<language>"  "<Address>"
 When User calls "AddPlaceAPI" with "Post" http request
 Then the API call is success with status code 200
 And "status" in response body is "OK"
 And "scope" in response body is "APP" 
  And verify the place_id created maps to "<name>" by using "getPlaceAPI" 
 
 Examples:
  |name |language   |Address   |
  |Aname| langA     |AddA      |
 #|Bname|langB      |AddB      |
 
 @DeletePlace @Regression
 Scenario: Verify the working of Delete Place functionality
 Given Delete Place Payload
 When User calls "deletePlaceAPI" with "POST" http request
 Then the API call is success with status code 200
 And "status" in response body is "OK"


 #Scenario: Verify if Place is being successfully addedusing AddPlace API's
 #Given Add Place Payload
 #When User calls "AddPlaceAPI" with Post http request
 #Then the API call is success with status code 200
 #And "status" in response body is "OK" 
 #And "scope" in response body is "APP" 
 