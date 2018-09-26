@echo off
javac -classpath ".\melissadata\personatorworld\org.apache.sling.commons.json-2.0.20.jar;" .\melissadata\personatorworld\*.java .\melissadata\personatorworld\view\*.java ./melissadata\personatorworld\model\*.java
java -classpath ".\melissadata\personatorworld\org.apache.sling.commons.json-2.0.20.jar;"; melissadata.personatorworld.Main melissadata.personatorworld.view.PersonatorWorldController melissadata.personatorworld.view.PersonatorWorldTransactionController melissadata.personatorworld.view.RootLayoutController melissadata.personatorworld.model.PersonatorWorldOption
del .\melissadata\personatorworld\*.class 
del .\melissadata\personatorworld\view\*.class 
del .\melissadata\personatorworld\model\*.class