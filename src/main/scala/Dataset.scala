//import SparkSession1.spark

// case class Dataset(author:String,title:String,pages:Int)

// case class Empty()

// import  spark.implicits._ 
// //create a dataset from csv file 
// val ds = spark.read
//             .csv("./spark-data/data.csv")
//             .as[Dataset]

// //create an empty dataset with zero columns
// val empty_ds = spark.emptyDataset[Empty]

// //create a dataset with a schema 
// val dsWithSchema = spark.emptyDataset[Dataset]

// //create a dataset with createDataset function 
// val dsCreated = spark.createDataset(Seq.empty(Dataset))

// //transformations and actions on dataset 
//     //it's the same thing such as Dataframes

// // // we will try to create a dataset and read data from json file 
//     //define the schema (the blueprint)
// case class Bloggers( id:Int, first:String, last:String, url:String)

//     // reading data 
// val ds_bloggers = spark.read.fromat("json")
//                         .option("path","path/to/file")
//                         .load()
//                         .as[Bloggers]


// // // creating a sample data 
// import scala.util.Random._
// import scala.util.Random

// case class Usage(uid:Int, uname:String, usage:Int)

// val r = new Random(42)
// // create 1000 instances of scala usage class

// val data = for (i <- 0 to 1000)
//     yield (Usage(i, "user-" + r.alphanumeric.take(5).mkString(""),r.nextInt(1000)))

// val ds_usage = spark.createDataset(data)

// ds_usage.filter(d => d.usage > 900)
//         .orderBy(desc("usage"))
//         .show(5,false)

// // another way to do it 
// def filterWithUsage(u:Usage) = u.usage > 900
// ds_usage.filter(filterWithUsage(_)).orderBy(desc("usage")).show(5)

