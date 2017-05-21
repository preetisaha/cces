# cces

<strong>Project Overview:</strong>
This is an online survey platform which utilizes cloud computing resources on demand to compute and provide some knowledgeable insight out of the survey data received. The platform consists of RESTful endpoints which store the received user input in a NoSQL Distributed Storage Platform (DynamoDB) as well as business logic to perform Analytical data analysis over the distributed storage engine. 
<br>
Technologies Used:
<ul>
<li>DynamoDB</li>
<li>AWS Elastic BeanStalk</li>
<li>Java</li>
<li>Spring-Boot</li>
</ul>
<ul>
<li>There is a screen shot of our EBS configuration below where PORT is 8080, Scaling is single instance, Instances – t1.micro and we are using Spring Boot Framework to design our application.</li>
<img src="./demo_images/section.png"/>

<li>This is how we can monitor our CPU </li>
<img src="./demo_images/cc1.png"/>

<li>My data lives in Distributed cloud storage called Dynamo DB from AWS. There is a screen shot below shows the table ‘survey_data’.

In the table an email is a primary key and one unique email represents one unique row which has column, nationality, age and favCar (Favorite car). So this is our survey platform where people can submit their reviews, and what application does is on the run it distributively compute the result and shows the age and choise of the car for a particular country.
If 2 people like honda then the result will be 2 (total).</li>
<img src="./demo_images/table.png"/>

<li>surveyController – Accepts the POST requests. AnalyticsController – Accept the analytic requests.AnalyticService – It is using Dynamo DB to compute and retrieve the data.SurveyService – Stores data into Dynamo DB.</li>

<li>To run a query on Dynamo DB we can select attributes that we have mentioned below, where we can see the American’s review by selecting the attribute.</li>
<img src="./demo_images/review.png"/>

<li>We are using restful application so we do do not have any HTML view, hence we are using Postman to post a survey and to retrieve analytic data which has shown in the screen shot below-

This is a JSON structure showing post request where the people are filling a survey form by providing their email, age , nationality and favCar. </li>
<img src="./demo_images/json.png"/>

<li>If a user wants to see the feedback he can see the responses through Postman GET responses which has been shown in the picture below.</li>
<img src="./demo_images/ccget.png"/>

<li>The above link will show the survey result of an European (Also shown in the figure)-</li>
<img src="./demo_images/survey2.png"/>

<li>This is how the result looks like-</li>
<img src="./demo_images/cc.png"/>
</ul>








