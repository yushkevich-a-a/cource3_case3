для запуска проекта необходимо:

1.  скачать junit-platform-console-standalone-1.10.5.jar и положить в корень проекта.
2.  скомпилировать файлы командой javac -cp "./junit-platform-console-standalone-1.10.5.jar" \*.java
3.  запустить проект командой java Main

для запуска тестов необходимо ввести в консоли
java -jar junit-platform-console-standalone-1.10.5.jar --class-path . --scan-classpath
