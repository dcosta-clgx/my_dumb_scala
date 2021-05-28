import org.apache.spark.sql.SparkSession;

object DumbSparkTest extends App {
    println("This is main()")

    val sparkSession: SparkSession = SparkSession.builder.getOrCreate
    val sparkContext: org.apache.spark.SparkContext = sparkSession.sparkContext

}
