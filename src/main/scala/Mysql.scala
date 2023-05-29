// import SparkSession1.spark

// class Mysql {
//     //Befor doing that we have to run : 
//         // bin/spark-shell --jars mysql-conector-java_8.0.16-bi.jar
//     //Read data from mysql
//         //driver is the class name of the jdbc driver to use to connect to the specified URL
//     val jdbc_df = spark.read.format("jdbc")
//                             .option("url","url_to_database")
//                             .option("driver","com.mysql.jdbc.Driver")
//                             .option("dbtable","[TABLEAME]")
//                             .option("user","[USERNAME]")
//                             .option("password","[PASSWORD]")
//                             .load()

//     //write data 
    
//     jdbc_df.write.format("jdbc")
//                 .option("url")
//                 .option("driver")
//                 .option("dbtable")
//                 .option("user")
//                 .option("password")
//                 .save()

  
// }
