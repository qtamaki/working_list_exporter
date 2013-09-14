package jp.applicative.gr
import org.json4s._
import org.json4s.native.JsonMethods._
import scala.io.Source
import java.io.FileInputStream
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.hssf.usermodel.HSSFWorkbook

/*
 * args: template file name, output file name, url
 */
object App extends App {
  
  args match {
    case Array(template, output, url) => {
      getJSON(url) match {
        case Some(json@JArray(_)) => makeXls(template, output, json)
        case _ => throw new RuntimeException("Argument error!")
      }
    }
    case _ => throw new RuntimeException("Argument error!")
  }

//  println(List("Hello,", "world", "!").mkString(" "))
//
//  println(parse(""" { "numbers" : [1, 2, 3, 4] } """))
//
//  val src = Source.fromURL("http://localhost:3000/api/worksheets?start_date=20130701&login=goldrush&password=furuponpon", "utf-8")
//  
//  var json = src.getLines.mkString
//  
//  println(json)
//  
//  println(parse(json))
  
  def getJSON(url: String):Option[JArray] = {
	  val src = Source.fromURL("http://localhost:3000/api/worksheets?start_date=20130701&login=goldrush&password=furuponpon", "utf-8")
	  
	  var json = src.getLines.mkString
	  
	  parse(json) match {
	    case array@JArray(x) => Some(array)
	    case _ => None
	  }
  }
  
  def makeXls(template: String, output: String, json: JArray) = {
        // Excelƒtƒ@ƒCƒ‹‚Ì“Ç‚İ‚İ    
    val fis = new FileInputStream(template);    
    println("Excel Template Open !! : " + template);
    val fs = new POIFSFileSystem(fis);    
    val workbook = new HSSFWorkbook(fs);
    
    for {
      JArray(list) <- json
      JObject(staffs) <- list
      JField("employee_name", employee_name) <- staffs
      JField("working_list", working_list) <- staffs
    }yield{
      println(employee_name)
      println(working_list)
    }
  }

}
