// class Codecommented {


//     println("Spark Version : "+spark.version)

//     import spark.implicits._  

//     val df = List("hello", "world").toDF  
//     df.show()

//     // //define a schema : 
//     //   // by dataframe api 
//     // val schema = StructType(Array(StructField("author",StringType,false),
//     //                               StructField("title",StringType,false),
//     //                               StructField("pages",IntegerType,false)))

//     //   // by DDL data definition language 
//     // val schema2 = "author STRING, tilte STRING, pages INT"
//     // //creating a dafaframe using schema 
//     // val data = Seq(Row("alla","Apache Spark",23))
//     // //println(data(0))
//     // val df2 = spark.createDataFrame(spark.sparkContext.parallelize(data),schema)
//     // df2.show()

//     // //from json or csv or txt 
//     // val df3 = spark.read.schema(schema).csv("/Users/neoxia/Documents/scalacode/sparktest/spark-data/data.csv")
//     // df3.show()
//     // println(df3.printSchema)

//     // //Colums and expressions = they have the same objectifs
//     // //col() : accept just column name as argument 
//     // //expr() : have more flexibility to use SQL-Like expressions as an argument.
//     // val df4 = df3.select(expr("pages * 2"))
//     // df4.show()
//     // val df5 = df3.select(col("pages") * 2)
//     // df5.show()

//     // //create a new culomn using expr 
//     // val df6 = df3.withColumn("B",(expr("pages > 100")))
//     // df6.show()

//     // //change a column type by expr() : 
//     // // val newDf = df.withColumn("age", expr("CAST(age as string) as age"))

//     // //concatenate some columns, create a new one and show it
//     // df3.withColumn("concatenateColumns",(concat(expr("author"),expr("pages")))).select(col("concatenateColumns")).show()

//     //Read the Covid file :
//     //val schema_covid = StructType(Array(StructField(""))) 
//     // val df_covid = spark.read.format("csv")
//     //                   .option("inferSchema","true")
//     //                   .option("header","true")
//     //                   .load("../spark-data/data.csv")
                
//     // //show the DataFrame
//     // df_covid.show()
//     val df_covid = spark.read
//                       .option("inferSchema","true")
//                       .option("header","true")
//                       .csv("./spark-data/coviddata.csv")
                
//     //show the DataFrame
//     df_covid.show()

//     //Create a temporary view 
//     df_covid.createOrReplaceTempView("temp_view")
//       //create a global view 
//     //df_covid.createOrReplaceGlobalView("global_view")
//     val df_result = spark.sql("""SELECT Direction,Year,Date FROM temp_view WHERE Year=2015""")
//     val df_result_2 = spark.read.table("temp_view")
//     df_result.show()

//     //Drop a view 
//     spark.catalog.dropGlobalTempView("temp_view")

//     //the metadata 
//     spark.catalog.listDatabases()
//     spark.catalog.listTables()
//     spark.catalog.listColumns("temp_view")


//     //sort by the value
//     //the $ is a spark fuction that convert name column to a Column.
//     //df_covid.sort(col("Value").desc).show(5)
//     //df_covid.sort($"Value".desc).show(5)

//     // //dataframewriter as parquet file
//     // //df3.write.format("csv").save("./spark-data/data-copy")
//     // // or 
//     // //df3.write.csv("./spark-data/data-copy")
//     // // and we ca add some options 
//     // //df3.write.option("header","true").csv("./spark-data/data-copy")

//     // //dataframewriter as a SQL table 
//     // // with a specific format 
//     // //df3.write.format("parquet").saveAsTable("my-table")

//     // //Save DataFrame into a table in a specific database:
//     // //df.write.option("database", "my_database").saveAsTable("my_table") 
//     // //or 
//     // //df.write.saveAsTable("my_database.my_table")
//     // //save into a default database 
//     // //df.write.saveAsTable("my_table")

//     // //Save DataFrame into a table with partition in a default database:
//     // //df.write.partitionBy("year", "month").saveAsTable("my_table")

//     // //Save DataFrame into a External table:
//     // //df.write.option("path", "/path/to/table").saveAsTable("my_table")

//     // //Projectios and filters 
//     // val df7 = df_covid.select("Direction","Year","Date","Value","Cumulative")
//     //                   .where($"Year" =!= "2015")
//     // df7.show()

//     // //filter with column condition (and the same thing we can do it with where() function)
//     // // for the comparison we have to use ===
//     // //df_covid.filter(col("Year") =!= "2015").show()
//     // //df_covid.filter('Year =!= "2015").show()
//     // //df_covid.filter($"Year" =!= "2015").show()
//     // //df_covid.filter(df_covid("Year") =!= "2015").show()

//     // //filter with SQL expression (the same thing for where() function)
//     // df_covid.filter("Year == 2015").show()

//     // //filter with multiple consitions :
//     //   //the OR : ||
//     //   // the AND : && 
//     //   //the NOT : ! 
    
//     // //filter on an array column 
//     // //import org.apache.spark.sql.functions.array_contains
//     // //df_covid.filter(array_contains(col("columname","value"))).show()

//     // //countDistinct 
//     // df_covid.select("Year")
//     //         .where(col("Year").isNotNull())
//     //         .agg(countDistinct("Year").alias("DistictYears"))
//     //         .show()
    
//     //to rename a column in dataframe we need to create a new one because 
//       //dataframe transformations are immutable.
//         //to do that we need to use "withColumnRename()" function
//     //val new_df_covid = df_covid.withColumnRename("Year","NewYear")


//     // // // sleep for 5 seconds
//     // //Thread.sleep(5000)


//     //***********creating tables by spark sql*******

//     //create a database 
//     spark.sql("""CREATE DATABASE database_test""")
//     spark.sql("""USE database_test""")
//       //create a managed table  && we do the same thing by saveAsTable
//     spark.sql("""CREATE TABLE managed_table_test (author STRING, title STRING, pages INT)""")

//       //create an unmanaged table (we have to specify the location of our data) && we can do it also by saveAsTable
//     spark.sql("""CREATE TABLE unmanaged_table_test (author STRING, title STRING, pages INT) USING csv OPTIONS (PATH './spark-data/data.csv')""")

//     //Read a data from a Binary file 
//     val df_binaryfile = spark.read.format("binaryFile")
//                               .option("pathGlobFilter","*.jpg")
//                               .load("path")
//         //to ignore partitioning data discovery in a directory, we use 
//         // option("recursiveFileLookup","true")
//         //which is available just i spark 3 or later.


//     //**********Interacting with external data source********args
//       //UDF
//     val cubed = (s:Long) => {
//       s * s * s
//     }
//       //register udf 
//     spark.udf.register("cubed",cubed)


//     //********* the function Joins *******args
//     df.join(
//       df2.as('df2_named),
//       $"df2_named.df2_colum1" === $"df_column2"
//     ).select("column3","column4").show()
    





//     spark.stop()
    
// }
