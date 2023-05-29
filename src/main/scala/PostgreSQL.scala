// import SparkSession1.spark
// import java.util.Properties
// //conecting to postgreSQL
// class PostgreSQL {
//     //read option 1
//   val jdbc_df1 = spark.read.format("jdbc")
//                         .option("url","jdbc:postgresql:[DBSERVER]")
//                         .option("dbtable","[SCHEMA].[TABLEAME]")
//                         .option("user","[USERNAME]")
//                         .option("password","[PASSWORD]")
//                         .load()
//     //read option 2
//     import java.util.properties
//     val cnxProp = new Properties()
//     cnxProp.put("user","[USERNAME]")
//     cnxProp.put("password","[PASSWORD]")
//     val jdbc_df2 = spark.read
//                         .jdbc("jdbc:postgresql:[DBSERVER]","[SCHEMA].[TABLEAME]",cnxProp)
    
//     //write data 
//     jdbc_df1.write.format("jdbc")
//                 .option("url")
//                 .option("dbtable")
//                 .option("user")
//                 .option("password")
//                 .save()

                    
// }
