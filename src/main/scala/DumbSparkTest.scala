import org.apache.spark.sql.SparkSession;

object DumbSparkTest extends App {
    def buildList(cardinality:Int): List[(Int,Int)] = {
        val theList = (1 to cardinality).toList
        theList.zipWithIndex
    }

    def mapper( pair:(Int,Int)): Int = {
      pair._1 + pair._2
    }

    def doSparkStuff(input: List[(Int,Int)]): List[Int] = {
        val sparkSession: SparkSession = SparkSession.builder.getOrCreate
        val sparkContext: org.apache.spark.SparkContext = sparkSession.sparkContext

        val inputRDD = sparkContext.makeRDD(input)

        val outputRDD = inputRDD.map( mapper )

        outputRDD.collect().toList
    }

    println("This is main()")

    val sumList = buildList(5 )

    println("Running non-Spark")
    val nonSparkResult = sumList.map(mapper)
    for ( i <- nonSparkResult) println(i)

    val sparkResult = doSparkStuff(sumList)
    for (i <- sparkResult) println(i)

}
