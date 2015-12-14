一、XML PULL介绍
	XmlPull和Sax类似，是基于流（stream）操作文件，然后根据节点事件回调开发者编写的处理程序。因为是基于流的处理，因此Xmlpull和Sax都比较节约内存资源，不会象Dom那样要把所有节点以对橡树的形式展现在内存中。
	但Xmlpull比Sax更简明，而且不需要扫描完整个流。现在XmlPull是一开源项目，并成为了Google android类库的一部分
	
二、基本操作
	1. 读取分析XML： com.hailiang.study.xml.parser.xmlpull.XmlReaderDemo01.java