

import org.apache.spark.sql.{DataFrame,Row}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import SparkSession1.spark


object SparkApp :

  def main(args: Array[String]) = {

    println("Spark Version : "+spark.version)

    //spark configuration
    //val sparkCofig = spark.conf.getAll
    //for (k <- sparkCofig.keySet) {println(s"${k} -> ${sparkCofig(k)}\n")}
    //Only Spark SQL config
    //spark.sql("SET -v").select("key","value").show(5,false)

    import spark.implicits._  

    val df = List("hello", "world").toDF  
    df.show()


    val df_covid = spark.read
                      .option("inferSchema","true")
                      .option("header","true")
                      .csv("./spark-data/coviddata.csv")
                
    //show the DataFrame
    df_covid.show()

    val df_test = df_covid.filter(col("Year") === "2015" && col("value") >= 61000000)
    df_test.show()

    df_test.withColumn("test",lit(1)).show()

    // val num = List(123,11,33,44) 
    // val dftest = spark.createDataset(num).toDF
    // dftest.show()

    val opendate = List(1100746394,1474410343)

    val opendatedf = spark.createDataset(opendate).toDF
    opendatedf.show

    opendatedf.withColumn("openTimestamp",col("value").cast("Timestamp")).withColumn("month",month(col("openTimestamp"))).withColumn("opendate",col("openTimestamp").cast("date")).show
    //opendatedf.withColumn("openDate",col("value").cast("date")).withColumn("month",month(col("openDate"))).show()

    //We can broadcast a dataframe without using the broadcast operation 
    // Set the autoBroadcastJoinThreshold parameter
    //spark.conf.set("spark.sql.autoBroadcastJoinThreshold", "10000000") // 10 MB

    // //test 
    // val peopleDF =
    //             Seq(   
    //             ("Ali", 0, Seq(100)),   
    //             ("Barbara", 1, Seq(300, 250, 100)),   
    //             ("Cesar", 1, Seq(350, 100)),   
    //             ("Dongmei", 1, Seq(400, 100)),   
    //             ("Eli", 2, Seq(250)),   
    //             ("Florita", 2, Seq(500, 300, 100)),   
    //             ("Gatimu", 3, Seq(300, 100)) 
    //             ).toDF("name", "department", "score")
   
    // import org.apache.spark.sql.expressions.Window
    // val windowspec = Window.partitionBy("department").orderBy(col("score").desc)
    // println(windowspec)
    


    spark.stop()

  }



