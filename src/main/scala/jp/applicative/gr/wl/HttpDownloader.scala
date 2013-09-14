package jp.applicative.gr.wl

import scala.io.Source
import org.json4s._
import org.json4s.native.JsonMethods._

class HttpDownloader(url: String) {
	val src = Source.fromURL(url,"utf-8")
	
}

object HttpDownloader {
  
}