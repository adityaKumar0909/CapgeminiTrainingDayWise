Question : 

Consider a database name “trainingdb” with a table training (trainingid auto generated with a sequence, topic, startDate, endDate, trainername, venue). Add minimum 6 rows in the table such that 2 trainings have finished, 2 tranings are ongoing and 2 tranings will be upcoming in near future.

Create an entity class for this. When the user sends a request to url “/trainings”, the program sends him all the upcoming and currently going on trainings in JSON format or String format.

On URL: “/trainings?name=spring” , it searches for all the trainings going on or upcoming the include the word “spring” in the topic.

On URL : “/trainings/upcoming?name=spring, it searches only for upcoming trainings, that include the word “spring” in topic