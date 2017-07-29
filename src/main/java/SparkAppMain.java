import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.File;
import java.io.IOException;

public class SparkAppMain {

    public static void main(String[] args) throws IOException {
//        File workaround = new File(".");
//        System.getProperties().put("hadoop.home.dir", workaround.getAbsolutePath());
//        new File("./bin").mkdirs();
//        new File("./bin/winutils.exe").createNewFile();
        SparkConf sparkConf = new SparkConf()
                .setAppName("Tribendu's Spark App");
                //.setMaster("local[*]");  // Delete this line when submitting to a cluster
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
        JavaRDD<String> stringJavaRDD = sparkContext.textFile("./temp/nationalparks.csv");
        System.out.println("Number of lines in file = " + stringJavaRDD.count());

    }

}
