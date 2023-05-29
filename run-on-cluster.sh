#the first step consists to create the jar file of the project, then to copy the projet jar into spark-apps 
#to get the project jar, you have to run sbt assembly. it will be stored in target directory.
sbt package

cp ./target/scala-3.1.1/sparktest_3-0.1.0-SNAPSHOT.jar ./spark-apps/sparktest-scala3.jar


docker compose exec spark-master /opt/spark/bin/spark-submit \
    --master spark://spark-master:7077 \
    --total-executor-cores 2 \
    --class SparkApp \
    --driver-memory 4G \
    --executor-memory 1G \
    /opt/spark-apps/sparktest-scala3.jar