@echo off
rd .\target /s /q
mkdir target
javac -classpath "lib\gson-2.8.9.jar;" -d .\target .\src\main\java\com\melissadata\personatorworld\*.java .\src\main\java\com\melissadata\personatorworld\model\*.java .\src\main\java\com\melissadata\personatorworld\view\*.java
xcopy src\main\resources\ target\ /s /q
xcopy lib\ target\lib\ /s /q