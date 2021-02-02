docker build -t score_db_image . && docker run --network spring_app --name score_db -p 3306:3306 -d score_db_image 
#docker build -t score_db_image . && docker run --name score_db -p 3306:3306 -d score_db_image 
