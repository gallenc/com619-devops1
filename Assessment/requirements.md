# Application requirements

You are required to create a hosted application which allows users to upload geographic points with descriptions of their current geo-location. 
Descriptions may also include a photo of the location.
The hosted application will display each point on an open street map derived map. Users who click on the points on the map will see a description of the location and a photo of the location if one was uploaded. 

![alt text](../Assessment/mapleaflet.png "Figure mapleaflet.png" )

Note - the primary objective of this exercise is to demonstrate a simple microservice using ReST and web technology.
The prettiness of the UI/UX design is not a primary criteria for evaluation.

You should prioritise the features listed and decide which ones to attempt in your three sprints.
You may not be able to implement all of the features in the time available but each sprint should demonstrate a working set of features. 

You should also provide a simple test plan which demonstrates testing of features at each sprint.

## Back end Server code

| Requirement | Description |        |
| ----------- | ----------- | ------ |
| 1 | the application will be secured with https using correct certificates |   |
| 2 | ReST api's will be documented using openAPI (swagger) |   |
| 3 | all dynamic data will be stored in a database |   |
| 4 | the application will support internationalisation i18n |   |
| 5 | user documentation will be included on the hosted site |   |
| 6 | the site will respect GPDR guidelines |   |
| 7 | the backend server will be hosted in the cloud and use container technology (docker) |   |
| 8 | user authentication will authenticate access to upload to the app |   |
| 9 | the app will support user and administrator roles and the signing up of new users |   |


## Client code

You may if you wish create a small android app which uses a ReST client to upload data to the hosted application. 
However it is also acceptable to use a web page which renders on the mobile device and uses javascript api's to access the geo-location.

| Requirement | Description |        |
| ----------- | ----------- | ------ |
| 1 | it shall be possible to use the application from a mobile device  |   |
| 2 | the web site will render on a mobile and desktop screen (responsive)  |   |
| 3 | the mobile client will include code to upload geolocation provided by the device  |   |
| 4 | The remote client must authenticate itself and use the ReST api to communicate with the hosted server. |   |
