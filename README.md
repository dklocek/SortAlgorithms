# SortAlgorithms

Just a URL based Sorter

#Usage

www.example.com/sort

Sorts numbers and strings.

<b>Required:</b>
  - table     Example => table=5,3,1,0,-2,2 or table=me,her,him,you
  - method    Exaple = > method=bubble 
  
  In general the URL <b><i>www.example.com/sort?table=5,3,1,0,-2,2&method=bubble </i></b>
   will asnwer [1,2,3]
   
  <b> Methods allowed </b>
  - bubble
  - insertion
  - quick
  - selection
  - merge
  - heap
  
<HR>
  
www.example.com/sortStudent

Student by chosen value <b><i>(id, name, surname, age)</i></b>

<b>Required:</b>
  - table       Example below
  - method      Example = > method=bubble
  - sortBy      Example = sortBy=id 
  
  <b> Methods allowed </b>
  - bubble
  - insertion
  - quick
  - selection
  - merge
  - heap  
  
  <i>Table</i>
  
  You need to provide data in table:
  - id
  - name
  - surname 
  - age 
 table=Student1;Student2;Student3...
 
 like this:
 
 table={"name":"a","surname":"b","id":"1","age":"5"};{"name":"c","surname":"d","id":"2","age":"15"}
 
 <b>IMPORTANT</b>
 
 You should use POST, if you want to use curl or url in browser, it should be encoded like:
 
 <i>table=%7B%22name%22%3A%22a%22%2C%22surname%22%3A%22b%22%2C%22id%22%3A%221%22%2C%22age%22%3A%225%22%7D%3B%7B%22name%22%3A%22c%22%2C%22surname%22%3A%22d%22%2C%22id%22%3A%222%22%2C%22age%22%3A%2215%22%7D</i>
 
 You can use https://onlinejsontools.com/url-encode-json
 
 Whole link look like:
 
 www.example.com/sortStudent?table=%7B%22name%22%3A%22a%22%2C%22surname%22%3A%22b%22%2C%22id%22%3A%222%22%2C%22age%22%3A%225%22%7D%3B%7B%22name%22%3A%22c%22%2C%22surname%22%3A%22d%22%2C%22id%22%3A%221%22%2C%22age%22%3A%2215%22%7D&sortBy=id&method=bubble
  
  and will return:
  
  [{"name":"c","surname":"d","id":1,"age":15},{"name":"a","surname":"b","id":2,"age":5}]