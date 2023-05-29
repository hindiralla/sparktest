import org.apache.spark.sql.SparkSession


object SparkSession1 {
      val spark = SparkSession.builder()
      .master(sys.env.getOrElse("SPARK_MASTER_URL","local[*]"))
      .config("spark.driver.bindAddress","127.0.0.1")
      .appName("SparkByExamples.com")
      .config("spark.dyamicAllocation.enabled","false")
      .config("spark.shuffle.service.enabled","false")
      .getOrCreate();
}
